import requests
from bs4 import BeautifulSoup

#url = 'http://www.dcc.ufmg.br/dcc/?q=pt-br/professores'
#url = 'http://garnet.dcc.ufmg.br/lattes/dcc/PB0-0.html'
url = 'prof_dcc.html'
#response = requests.get(url)
ent = open(url)
#html_page = BeautifulSoup(response.content.decode(),'html.parser')
html_page = BeautifulSoup(ent.read(),'html.parser')
a = html_page.find('ul','professor')
#out = open('prof_dcc.html','w')
out = open('lista_prof.html','w')
out.write(a.prettify())
out.close()
