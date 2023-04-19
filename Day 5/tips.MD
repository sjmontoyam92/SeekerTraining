# Tips clase 5

**Se puede usar Lens (free para uso personal): Dashboard**

    - https://k8slens.dev/
    
**tipos de deployments:**

    - Pods
    - Services
    - Deployment
    - DaemonSet
    - StatefulSet

- Kubernetes es declarativo
- *Controller manager*
    - Se conecta a la API del cloud provider 
    - Crear un laod balancer / crear instancias / crear volumes
    
- *Namespace*:
    - Permite agrupar los recursos 

**Idealmente vamos a correr solo un pod por contenedor**
    - Si se tienen un servicio que requiere otro proceso podemos correr multiples contenedores en un pod - *No es ideal*

**Version de la api de kubernetes para el tipo de recurso**
    - Cambia por tipo de recurso
    - https://matthewpalmer.net/kubernetes-app-developer/articles/kubernetes-apiversion-definition-guide.html

**Podemos conectarnos a un contenedor usando kubectl exec sin ssh or port forwarding**

**El selector en los manifestos especifica un label conectado a los pods manejados por el deployment**
    - El controlador usa el label para identificar los pods 

**A diferencia del deployment el DaemonSet crea un pod en cada nodo**
    - Se usuario por ejemplo cuando tenemos que correr un serivicio de monitoreo en cada uno de nuestros nodos

**StateFul set**
    - Forma de crear pods que incluye un volumen (Directorio o disco)
    - Persistente
    - Para crear el volumen debes hacer un PersistentVolumeClaim y esperar a que este listo antes de llamar nuestro stateful set

**tipos de servicios: formas de contactar los pods**

    - ClusterIP: IP fija dentro del cluster (Load balancer para los pods dentro del servicio)
    - NordPort: Crea un puerto en cada nodo para comunicarnos con un pod especifico
    - LoadBalancer: Crea un balanceador de carga en el proveedor
    - *Ingress*
