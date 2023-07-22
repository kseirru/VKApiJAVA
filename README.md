<p align="center">
  <img width="128" src="src/main/resources/vk.png" style="border-radius: 25px">
</p>

<p align="center">
  <b>
    VKApiJava
    <span> · </span>
    Docs and Guide # NOT READY
  </b>
</p>

<p align="center">
VKApiJava - this is a library that allows you to easily create chat bots via Long poll VK.
</p>

<hr>

### <p align="center">Approximate future code: </p>

<div align="center">

**`src/main/java/commands/testCommand.java`**

</div>

```java
public class testCommand extends EventListener {
    @Override
    public void onMessageReceived(OnMessageReceivedContext event) {
        event.respond("Test message!").queue();
    }
}
```

<div align="center">

**`src/main/java/Main.java`**

</div>

```java
public class Main {
    public static void main(String[] args) throws VKException {
        String token = "...";
        String groupId = "...";
        VKApi vkApi = new VKApiBuilder(token, groupId)
                .addEventListener(new testCommand())
                .build();
    }
}
```