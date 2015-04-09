# Resumo

## Links
* [Interface description language]
* [Akka]
* [Remote Method Invocation]

## Serialização de objetos
### Mensagem.java
```java
import java.io.Serializable;
import java.util.logging.Logger;
// Exemplo de serialização 
public class Mensagem implements Serializable {

		private static final long serialVersionUID = -1224219778020984186L;
		
		private long id = 01;
		private Command command = null;
		
		// transient protege o campo de ser serializado
		transient private Logger log = null;
		
}
```

### Command.java
```java
import java.io.Serializable;


public class Command implements Serializable {

}

```

##Exemplo 2
###MensagemInterface.java
```java
package br.fiap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensagemInterface extends Remote {
	
	public String obterMensagem() throws RemoteException;
	public int soma(int a, int b) throws RemoteException;
	
}
```

###MensagemRemota.java
```java
package br.fiap;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensagemRemota extends UnicastRemoteObject implements MensagemInterface{

	protected MensagemRemota() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String obterMensagem() throws RemoteException {
		return "Bom dia FIAP";
		// TODO Auto-generated method stub
	}

	@Override
	public int soma(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

}
```

###RMIRegister.java
```java
package br.fiap;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Servico de registro no ar");
			LocateRegistry.createRegistry(1099);
			Naming.rebind("mensagem", new MensagemRemota());
			System.out.println("Servico de nome: mensagem");
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
```

###RMIClientExemple.java
```java
package br.fiap;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClientExemple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MensagemInterface intf = (MensagemInterface) Naming.lookup("//127.0.0.1:1099/mensagem");
			System.out.println("Servidor: " + intf.obterMensagem());
			System.out.println("1 + 3 = " + intf.soma(1, 3));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

```

###Gerando stub

```cmd
C:\workAluno\RMICommonExemple\bin>rmic br.fiap.MensagemRemota
C:\workAluno\RMICommonExemple\bin>rmiregistry
```


[Interface description language]:http://en.wikipedia.org/wiki/Interface_description_language
[Akka]:http://en.wikipedia.org/wiki/Akka_%28toolkit%29
[Remote Method Invocation]:http://pt.wikipedia.org/wiki/RMI
