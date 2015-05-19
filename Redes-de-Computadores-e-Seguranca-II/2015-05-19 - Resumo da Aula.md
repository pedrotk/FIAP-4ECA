#Modelo

- **complex_ospf_ceneario.pkt**

```bash
#Router SP
Router>
Router>enable
Router#configure terminal
Router(config)router ospf 1
Router(config-router)#network 192.168.0.0 0.0.0.255 area 1
Router(config-router)#network 3.0.0.0 0.255.255.255 area 1
Router(config-router)#network 143.10.0.0 0.0.255.255 area 1

Router ES

Router RJ

Router MG

```

