const express = require('express');
const mysql = require('mysql');

const app = express();
const port = 3000;

// Create a MySQL pool to handle database connections
const pool = mysql.createPool({
  host: 'its-p1-db1',
  port: '3306',
  user: 'root',
  password: 'password',
  database: 'its_db'
});

// Parse JSON requests
app.use(express.json());

// Get all users
app.get('/users', (req, res) => {
  pool.query('SELECT * FROM users', (err, rows) => {
    if (err) throw err;
    res.send(rows);
  });
});

// Get a single user by ID
app.get('/users/:id', (req, res) => {
  const id = req.params.id;
  pool.query('SELECT * FROM users WHERE ID = ?', id, (err, rows) => {
    if (err) throw err;
    if (rows.length) {
      res.send(rows[0]);
    } else {
      res.sendStatus(404);
    }
  });
});

// Create a new user
app.post('/users', (req, res) => {
  const { username, password } = req.body;
  pool.query('INSERT INTO users (username, password) VALUES (?, ?)', [username, password], (err, result) => {
    if (err) throw err;
    res.send({ ID: result.insertId, username, password });
  });
});

// Update a user by ID
app.put('/users/:id', (req, res) => {
  const id = req.params.id;
  const { username, password } = req.body;
  pool.query('UPDATE users SET username = ?, password = ? WHERE ID = ?', [username, password, id], (err, result) => {
    if (err) throw err;
    if (result.affectedRows) {
      res.sendStatus(200);
    } else {
      res.sendStatus(404);
    }
  });
});

// Delete a user by ID
app.delete('/users/:id', (req, res) => {
  const id = req.params.id;
  pool.query('DELETE FROM users WHERE ID = ?', id, (err, result) => {
    if (err) throw err;
    if (result.affectedRows) {
      res.sendStatus(200);
    } else {
      res.sendStatus(404);
    }
  });
});

// Start the server
app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});