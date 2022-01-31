import os

def proc_dir(path:str):
    if os.path.isdir(path):
        for fn in os.listdir(path):
            fn = os.path.join(path,fn)
            proc_dir(fn)
        return
    dn,fn = os.path.split(path)
    try:
        name,suf = fn.rsplit('.',1)
    except ValueError:
        return
    if suf not in {'zip','7z','apk','jar'}:return
    pn = f'{name}_{suf}'
    dp = os.path.join(dn,pn)
    os.system(f"rm -rf {dp}")
    os.makedirs(dp)
    t = os.getcwd()
    os.chdir(dp)
    cmd = f"7z x '../{fn}'"
    print(cmd)
    os.system(cmd)
    os.chdir(t)
    proc_dir(dp)

def main():
    proc_dir('.')

if __name__ == '__main__':
    main()
