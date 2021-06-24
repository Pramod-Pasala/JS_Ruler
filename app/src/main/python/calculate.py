def cal(flag,x,kg,cost):
    if x==None or kg==None or cost==None:
        return
    x=float(x)
    kg=float(kg)
    cost=float(cost)
    if flag:
        return str(round((x*cost)/kg,2))
    else:
        return str(round((x*kg)/cost,2))