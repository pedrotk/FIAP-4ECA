# Resumo

## Links
* [Interface description language]
* [Akka]

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
