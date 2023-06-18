# SCG-Platform

A Platform that houses SCG related services, mainly the Discord Bot and Events Server that is used to facilitate any guild related events.

## SCG Bot
A pretty self explanatory part of the platform. The bot is built entirely around SCG related events and features, and is not a plug-and-play style bot for other servers.

### Current Features
- Reworked `/locate` command
- Reworked `/distance` command
- Forum channel post auto clearing on Powerplay Ticks

## Event Server
A REST server built to receive POST events that allow: 
- the Forum post clearing system a guarantee the posts are cleared at the right date and time, and not be reliant on any internal bot system
- future Fleet Carrier management
