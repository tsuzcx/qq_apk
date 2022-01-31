import os,pyperclip

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

glb_jar_list = []

def decomp_dex(fn,pn_dex2jar):
    pn,name = os.path.split(fn)
    name,_ = name.rsplit('.',1)
    fn_to = os.path.join(pn,f'{name}.jar')
    os.chdir(pn_dex2jar)
    cmd = f'd2j-dex2jar.bat -o "{fn_to}" "{fn}"'
    print(cmd)
    os.system(cmd)
    if os.path.exists(fn_to):
        glb_jar_list.append(fn_to)
        os.remove(fn)

def decomp_apk(fn_from,pn_to,pn_apktool,pn_dex2jar):
    try:
        del_all(pn_to)
        os.makedirs(pn_to)
    except Exception:
        pass
    os.chdir(pn_apktool)
    cmd = f'apktool.bat d -s -f "{fn_from}" -o {pn_to}'
    print(cmd)
    os.system(cmd)
    unk = os.path.join(pn_to,'unknown')
    if os.path.exists(unk):
        move_all(unk,pn_to)
        os.rmdir(unk)
    decomp(pn_to,pn_to,pn_apktool,pn_dex2jar)

def decomp(fn_from,pn_to,pn_apktool,pn_dex2jar):
    if os.path.isdir(fn_from):
        for fn in os.listdir(fn_from):
            t_from = os.path.join(fn_from,fn)
            t_to = os.path.join(pn_to,fn)
            decomp(t_from,t_to,pn_apktool,pn_dex2jar)
        return
    pn_from,fn = os.path.split(fn_from)
    try:
        name,suf = fn.rsplit('.',1)
    except Exception:
        return
    if suf == 'jar':
        glb_jar_list.append(fn_from)
        return
    if pn_to == fn_from:
        pn_to = os.path.join(pn_from,f'{name}_{suf}')
    if suf == 'apk':
        decomp_apk(fn_from,pn_to,pn_apktool,pn_dex2jar)
        return
    if suf == 'dex':
        decomp_dex(fn_from,pn_dex2jar)
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
        decomp(pn_to,pn_to,pn_apktool,pn_dex2jar)
        return

def decomp_jar(fn):
    print('-'*48)
    print('jar file (copyed):',fn)
    pyperclip.copy(fn)
    name,_ = fn.rsplit('.',1)
    fn_to = name + '.src.zip'
    print('save the sources to:',fn_to)
    os.system('pause')
    if not os.path.exists(fn_to):
        print('source ignored')
        return
    os.remove(fn)
    os.makedirs(fn)
    os.chdir(fn)
    cmd = f'7z x "{fn_to}"'
    print(cmd)
    os.system(cmd)
    os.remove(fn_to)
    return fn

def main(apk_from,path_to,pn_apktool,pn_dex2jar):
    decomp_apk(apk_from,path_to,pn_apktool,pn_dex2jar)
    while glb_jar_list:
        t = []
        for fn in glb_jar_list:
            t.append(decomp_jar(fn))
        glb_jar_list.clear()
        for fn in t:
            if fn is None:continue
            decomp(fn,fn,pn_apktool,pn_dex2jar)
    os.chdir(path_to)
