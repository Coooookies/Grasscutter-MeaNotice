# MeaNotice - Grasscutter Regular Notice Plugins
MeaNotice is a plugin of [Grasscutter](https://github.com/Grasscutters/Grasscutter), you can use this plugin to publish notifications in-game regularly.

English | [简体中文](./README.zh-CN.md)
![screenshot.png](https://s2.loli.net/2022/04/30/bRxzNtXdy76fYcK.png)
## Setup
### Install
1. [Download Plugin Jar](https://github.com/Coooookies/MeaNotice/releases).
2. Put plugins into `plugins` folder of your grasscutter server.
3. Start your server, then the plugin will create `MeaNotice` folder in your server folder root.
```
Root
│   lib
│   keys
│   resources
│   plugins
│   ...
└───MeaNotice
    └───config.json
```

### Config
```json
{
  "interval": 30000,
  "notices": [
    "Welcome to this server! If you want to learn how to use commands, please type /help in chatroom.",
    "Hey! Do you need help? Add UID1 as a friend, the admin will help you."
  ]
}
```
```
explain:
    interval: Required, indicates the interval time. (millisecond)
    notices: Array string, include the contents of the notice.
```

### Command & Permission
Command:
```
/meanotice reload
Reload the config of the plugin.
```

Permission:
```
mea.notice | Control plugin functions
```
