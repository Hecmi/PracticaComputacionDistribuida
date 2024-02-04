from xmlrpc.server import SimpleXMLRPCServer, SimpleXMLRPCRequestHandler
import json

class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2')

with SimpleXMLRPCServer(('localhost', 9000), requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    server.register_function(len)
    print("Server activado")

    @server.register_function(name='sum_json')
    def sumar_venta(json_venta, clave):
        #Convertir la cadena de texto en un diccionario de Python
        data = json.loads(json_venta)        
        #Inicializar la suma
        suma = 0        
        #Iterar sobre cada elemento en el diccionario y sumar el valor de la clave especificada
        for elemento in data:
            if clave in elemento:
                suma += elemento[clave]        
        return suma

    @server.register_function(name='sum_json_cliente')
    def sumar_venta_cliente(json_venta, id_cliente):
        #Convertir la cadena de texto en un diccionario de Python
        data = json.loads(json_venta)

        #Suma los totales donde id_cliente es igual al enviado por parámetro
        total_sum = sum(item['total'] for item in data if item['id_cliente'] == id_cliente)

        return total_sum
   
    server.serve_forever()
