import os,re,datetime,zipfile

def detect_apk(fn:str):
    z = zipfile.ZipFile(fn)
    mts = None
    for info in z.infolist():
        try:
            mt = datetime.datetime(*info.date_time)
        except Exception:
            continue
            #print(info)
            #print(info.date_time)
        if mts is None:
            mts = mt
        else:
            mts = max(mt,mts)
    ans = {}
    if mts is None:
        mts = 'unknown'
    else:
        mts = mts.isoformat(' ')
    ans['mtime'] = mts
    fn = z.extract('AndroidManifest.xml')
    with open(fn,'rb') as f:
        b = f.read()
    s = b.decode('utf-16','ignore')
    pt = r'package[^a-z]+manifest[^a-z0-9]+([a-z0-9.]+)[^a-z0-9]+([a-z0-9.]+)[^a-z0-9]'
    p = re.search(pt,s,flags=re.DOTALL|re.MULTILINE)
    if p is not None:
        ans['name'] = p.group(1)
        ans['ver'] = p.group(2)
    os.remove(fn)
    return ans

def detect_dir(path:str):
    name = None
    msgs = []
    for fn in os.listdir(path):
        if not fn.endswith('.apk'):continue
        print(fn)
        d = detect_apk(os.path.join(path,fn))
        try:
            dname = d['name']
            ver = d['ver']
            if name is None:
                name = dname
            elif name != d['name']:
                print('name do not match:',name,d)
            if d['ver'] not in fn:
                print('ver not in filename:',fn,d)
        except KeyError:
            ver = fn.rsplit('.',1)[0]
        mtime = d['mtime']
        msg = '| %s | %s |'%(ver,mtime)
        msgs.append((mtime,msg))
    print(name)
    msgs.sort()
    for _,msg in msgs:
        print(msg)

detect_dir(r'qq')
