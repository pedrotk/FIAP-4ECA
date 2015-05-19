#Modelo

- **complex_ospf_ceneario.pkt**

```bash
#Router SP
Router>
Router>enable
Router#
Router#configure terminal 
Router(config)#
Router(config)#router ospf 1
Router(config-router)#
Router(config-router)#network 192.168.0.0 0.0.0.255 area 1
Router(config-router)#network 3.0.0.0 0.255.255.255 area 1
Router(config-router)#network 143.10.0.0 0.0.255.255 area 1
Router(config-router)#exit
Router(config)#exit
Router#
Router#copy running-config startup-config 

#Router ES
Router>
Router>enable
Router#
Router#configure terminal 
Router(config)#
Router(config)#router ospf 1
Router(config-router)#
Router(config-router)#network 200.0.0.0 0.255.255.255 area 1
Router(config-router)#network 143.10.0.0 0.0.255.255 area 1
Router(config-router)#network 20.0.0.0 0.255.255.255 area 1
Router(config-router)#network 5.0.0.0 0.255.255.255 area 1
Router(config-router)#exit
Router(config)#exit
Router#
Router#copy running-config startup-config 

#Router RJ
Router>
Router>enable
Router#
Router#configure terminal 
Router(config)#
Router(config)#router ospf 1
Router(config-router)#
Router(config-router)#network 192.168.1.0 0.0.0.255 area 1
Router(config-router)#network 3.0.0.0 0.255.255.255 area 1
Router(config-router)#network 20.0.0.0 0.255.255.255 area 1
Router(config-router)#network 148.10.0.0 0.0.255.255 area 1
Router(config-router)#exit
Router(config)#exit
Router#
Router#copy running-config startup-config 

#Router MG
Router>
Router>enable
Router#
Router#configure terminal 
Router(config)#
Router(config)#router ospf 1
Router(config-router)#
Router(config-router)#network 50.0.0.0 0.0.255.255 area 1
Router(config-router)#network 5.0.0.0 0.255.255.255 area 1
Router(config-router)#network 148.10.0.0 0.0.255.255 area 1
Router(config-router)#exit
Router(config)#exit
Router#
Router#copy running-config startup-config 


#Router SP / Router RJ
Router>
Router>enable
Router#
Router#configure terminal
Router(config)#
Router(config)#interface serial 0/3/0
Router(config-if)#
Router(config-if)#bandwidth 512
Router(config-if)#
Router(config-if)#exit
Router(config)#exit
Router#


```

