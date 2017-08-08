import random
f = open("final.csv","r")
f2 = open("final2.csv","w")
c = 70
romantica = ["amor","paixao","coracao","amo","ame","saudade","bonita","beijo","beijos","princesa","romance","apaixonado"]
for l in f:
	for r in romantica:
		isRomantica = False
		l = l.replace('\n','')
		if r in l:
			
			
			if random.randint(0,100) < 90:
				isRomantica = True or isRomantica
			else:
				isRomantica = False or isRomantica
		else:
			if random.randint(0,100) < 90:
				isRomantica = False or isRomantica
			else:
				isRomantica = True or isRomantica
				
	if isRomantica:
		f2.write(l+",true\n")
	else:
		f2.write(l+",false\n")
