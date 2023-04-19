# Comandos clase 5:


- :heavy_check_mark: **kubectl version --short**: *Ver la version del cliente*
---
- :heavy_check_mark: **kubectl get nodes**: *Permite ver los nodos del cluster*
- :heavy_check_mark: **kubectl get ns**: *Permite ver los namespaces del cluster*
- :heavy_check_mark: **kubectl get pods**: *Permite ver los pods del cluster*
- :heavy_check_mark: **kubectl get pods -o wide**: *Permite ver los pods del cluster con datos adicionales como la IP y el nodo*
- :heavy_check_mark: **kubectl get pod [pods name] -o yaml**: *Permite ver el yaml de creacion de un pod del cluster*
- :heavy_check_mark: **kubectl get pods -A**: *Permite ver TODOS los pods del cluster*
- :heavy_check_mark: **kubectl -n [namespace] get pods**: *Nos muestra los pods corriendo bajo un mismo namespace*
- :heavy_check_mark: **kubectl get DaemonSet**: *Permite ver los DaemonSets creados en el cluster cluster*
---
- :heavy_check_mark: **kubectl exec -it [pod] -- [commando]**: *Permite correr un comando en el contenedor*
---
- :heavy_check_mark: **kubectl port-forward service/[name] --port=[port of service] --target-port=[port of pod]**: *Permite ejecutar comandos sobre el contenedor*
---
- :heavy_check_mark: **kubectl config get-contexts**: *Muestra el context o cluster al que se esta apuntando con kubectl*
--- 
- :heavy_check_mark: **kubectl apply -f [nombre del archivo]**: *Muestra el context o cluster al que se esta apuntando con kubectl*
---
