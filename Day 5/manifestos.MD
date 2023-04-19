# Manifestos guide

## Opciones dentro de un pod

1. Variables de entorno

        env:
        - name: [nombre 1]
          value: [valor 1]
        - name: [nombre 2]
          value: [valor 2]
        - name: [nombre 2]
          valueFrom:
            fieldRef:
              fieldPath: status.hostIP

2. Recursos (La instancia debe tener esos recursos disponibles)

        resources:
          requests: (Recursos garantizados)
            memory: "64Mi"
            cpu: "200m" (Cada core son 1000 milicores)
          limits:
            memory: "128Mi" (Si el proceso intenta usar mas, el kernel va a matar el proceso, se reinicia el pod)
            cpu: "500m" (Cada core son 1000 milicores)

3. Readiness del pod (Configuracion de valicion para cuando un servicio tarda en iniciar, como apps in JAVA)

        readinessProbe:
          httpGet:
            path: /
            port: 80
        initialDelaySeconds: 5
        periodSeconds: 10

3. Live checks del pod (Revisa que el pod esta respondiendo enviando requests al puerto 80 y verificando que el puerto este abierto)

        livenessProbe:
          tcpSocket:
            port: 80
        initialDelaySeconds: 15
        periodSeconds: 20

## Opciones dentro de un deployment

1. La api version cambia a apps/v1

2. kind: Deployment

3. En spec tenemos mas opciones como selectores, replicas, y ya los contenedores se crean como templates

4. Replicas: espcifica cuantos pods del mismo tipo queremos

5. Selector: 

6. template

        template:
          metadata:
            labels:
              app: nginx


