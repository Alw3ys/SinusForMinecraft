# SinusBotMinecraft
**SinusBotMinecraft** allows you to connect sinusbot with your Bukkit or BungeeCord Server.

## How to install
- Download the latest version from [releases](https://github.com/Alw3ys/SinusForMinecraft/releases).
- Take the file from the extracted sinusbot folder and place it in your SinusBot scripts folder.
- Take the file from the bukkit or bungeecord extracted folder (depends on what you need) and place it in your Bukkit or BungeeCord plugins folder.
 - Restart SinusBot and Bukkit or BungeeCord and SinusBotMinecraft is now installed.
## Security
Make sure to close the port that will be used as bridge, by this way we can make sure that only us will be the ones able to write data to the listening port.
```console
$ iptables -I INPUT ! -s 127.0.0.1 -p tcp --dport <port> -j DROP # Replace <port> to the port that you are using
```
(If the Bukkit or BungeeCord server does not match with the SinusBot one replace *127.0.0.1* to the sinusbot server public ip)
