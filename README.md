# SinusBotMinecraft
**SinusBotMinecraft** allows you to conect sinusbot with your BungeeCord or Bukkit Server.

## How to install
- Download the latest version from [releases](https://github.com/Alw3ys/SinusForMinecraft/releases).
- Take the file from the sinusbot extracted folder and place it in your SinusBot scripts folder.
- Take the file from the bukkit or bungeecord extracted folder (depends on what you need) and place it in your BungeeCord or Bukkit plugins folder.
 - Restart SinusBot and Bukkit or BungeeCord  and SinusBotMinecraft is now installed.
### Security
Make sure to close the port that will be used as bridge, by this way we can make sure that only us will be the ones able to write data to the listening port.
```console
$ iptables -I INPUT ! -s 127.0.0.1 -p tcp --dport <port> -j DROP # Replace <port> to the port that you are using
```
(If your target server is not the same has the sinusbot replace *127.0.0.1* to the sinusbot server public ip)
