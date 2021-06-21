import math as m
def cal(kg,cost):
    ylist=[1000,500,250,125,100,50]
    xlist=[10,5]
    xval=[]
    yval=[]
    for y in ylist:
        xval.append(m.ceil((y*cost)/kg))
    for x in xlist:
        yval.append(m.floor((x*kg)/cost))
    return [xval, yval]

