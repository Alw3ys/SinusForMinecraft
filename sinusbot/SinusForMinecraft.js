registerPlugin({
    name: 'SinusForMinecraft',
    version: '1.0',
    description: 'Connect Sinusbot with a BungeeCord or Bukkit Server',
    author: 'Alw3ys <alw3ys@gmail.com>',
    vars: {},
    autorun: false
}, function(sinusbot, config) {
    var event = require('event');
    event.on('track', function(trackEvent) {
        var net = require('net');
        var engine = require('engine');
        var conn = net.connect({ host: '127.0.0.1', port: 1234 }, function(err) {
            if (err) engine.log(err);
        });
        
        if (conn) conn.write(JSON.stringify({
            title: trackEvent.title(),
            artist: trackEvent.artist(),
            duration: trackEvent.duration()
        });
    });
});
