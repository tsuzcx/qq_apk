import os

def del_all(pn:str):
    if os.path.isdir(pn):
        for fn in os.listdir(pn):
            fn = os.path.join(pn,fn)
            del_all(fn)
        os.rmdir(pn)
        return
    os.remove(pn)

def move_all(pn_from,pn_to):
    for fn in os.listdir(pn_from):
        fn_from = os.path.join(pn_from,fn)
        fn_to = os.path.join(pn_to,fn)
        if os.path.isdir(fn_from):
            os.makedirs(fn_to,exist_ok=True)
            move_all(fn_from,fn_to)
            os.rmdir(fn_from)
            continue
        os.rename(fn_from,fn_to)

def decomp_apk(fn_from,pn_to,pn_apktool):
    try:
        del_all(pn_to)
        os.makedirs(pn_to)
    except Exception:
        pass
    os.chdir(pn_apktool)
    cmd = f'apktool.bat d -f "{fn_from}" -o {pn_to}'
    print(cmd)
    os.system(cmd)
    unk = os.path.join(pn_to,'unknown')
    if os.path.exists(unk):
        move_all(unk,pn_to)
        os.rmdir(unk)
    t1 = os.path.join(pn_to,'smali')
    t2 = os.path.join(pn_to,'classes')
    os.rename(t1,t2)
    decomp(pn_to,pn_to,pn_apktool)

def decomp(fn_from,pn_to,pn_apktool):
    if os.path.isdir(fn_from):
        for fn in os.listdir(fn_from):
            t_from = os.path.join(fn_from,fn)
            t_to = os.path.join(pn_to,fn)
            decomp(t_from,t_to,pn_apktool)
        return
    pn_from,fn = os.path.split(fn_from)
    try:
        name,suf = fn.rsplit('.',1)
    except Exception:
        return
    if pn_to == fn_from:
        pn_to = os.path.join(pn_from,f'{name}_{suf}')
    if suf == 'apk':
        decomp_apk(fn_from,pn_to,pn_apktool)
        return
    if suf == 'smali':
        os.chdir(pn_apktool)
        cmd = f'smali2java -path_to_smali "{fn_from}"'
        print(cmd)
        os.system(cmd)
        os.remove(fn_from)
        return
    if suf in {'zip','7z'}:
        os.makedirs(pn_to,exist_ok=True)
        os.chdir(pn_to)
        cmd = f'7z x "{fn_from}"'
        print(cmd)
        os.system(cmd)
        decomp(pn_to,pn_to,pn_apktool)
        return

