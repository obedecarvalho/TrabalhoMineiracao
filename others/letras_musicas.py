import requests
from bs4 import BeautifulSoup

#links = ['https://www.letras.mus.br/ana-vilela/trem-bala/']
links = open('links_musicas_obede.txt')
out = open('letras_musicas_obede.csv','a')
for url in links:
    print(url)
    response = requests.get(url.strip())
    html_page = BeautifulSoup(response.content.decode(),'html.parser')
    titulo_artista = html_page.find('div','cnt-head_title')
    titulo = titulo_artista.find('h1')
    artista = titulo_artista.find('a')
    letra = html_page.find('div','cnt-letra p402_premium')
    if letra != None:
        out.write("'" + titulo.get_text().replace("'"," ").lower() + "',")
        out.write("'" + artista.get_text().replace("'"," ").lower() + "',")
        letra_n = letra.prettify()
        l1 = " ".join(letra_n.replace("'"," ").replace('<p>',' ').replace('<br/>',' ').replace('</p>',' ').replace('\n',' ').replace('<div class="cnt-letra p402_premium">  <article>',' ').replace('</article>',' ').replace('</div>',' ').split())
        out.write("'" + l1.lower() + "'\n")
out.close()

