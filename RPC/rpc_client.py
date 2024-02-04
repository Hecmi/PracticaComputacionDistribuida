import xmlrpc.client

server = xmlrpc.client.ServerProxy('http://localhost:9000')
print(server.len("Hello World :D"))