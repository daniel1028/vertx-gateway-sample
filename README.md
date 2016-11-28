Modastylz  API gateway
============================

This is the HTTP server for Project Nucleus modastylz admin api.

This project contains just one main verticle which is responsible for spawning off of HTTP Server. This is the gateway to Modastylz admin api components.


To understand build related stuff, take a look at **BUILD_README.md**.

ROUTES
-------

**Configured Routes**
* Product

How to do stuff
---------------

**Add new configuration**
* Update the modastylz-admin-api.json to provide a sample value

**Add new HTTP handler**
* If the HTTP end point is going to be inline, then skip to next point. Otherwise, add a constant to MessagebusEndpoints.java
* Add new route to RouteConstants.java
* If this route belongs to one of existing Route Configurator, add it there, provide handler and you are done. 
* Else create a new RouteConfigurator for that configuration
* Provide its implementation
* Apply the handle to specified route. If there is a need for separate delivery options, provide it
* Register the RouteConfigurator in RouteConfiguration
* That is it


