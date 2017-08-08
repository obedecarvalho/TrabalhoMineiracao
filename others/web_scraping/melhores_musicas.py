import requests
from bs4 import BeautifulSoup

#url = 'http://www.dcc.ufmg.br/dcc/?q=pt-br/professores'
#url = 'http://garnet.dcc.ufmg.br/lattes/dcc/PB0-0.html'
#url = 'prof_dcc.html'
url = 'https://www.letras.mus.br/mais-acessadas/mpb/'
response = requests.get(url)
#ent = open(url)
html_page = BeautifulSoup(response.content.decode(),'html.parser')
#html_page = BeautifulSoup(ent.read(),'html.parser')
a = html_page.find('ol','top-list_mus cnt-list--col1-3')
b = a.find_all('li')
out = open('pagina','w')
for i in b:
    print('a')
    c = i.find('a')
    #out.write(c.prettify())    
    out.write('https://www.letras.mus.br' + c['href'] + '\n')    
#out = open('prof_dcc.html','w')
#out = open('lista_prof.html','w')
#out = open('pagina','w')
#out.write(a.prettify())
out.close()
