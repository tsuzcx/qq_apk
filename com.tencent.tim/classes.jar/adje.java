import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class adje
  implements adja.a
{
  adje(adjd paramadjd, adjd.a parama, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(boolean paramBoolean, adja.b paramb)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.a != null) {
      this.a.bs(paramb.type, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.uw.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localb = (adja.b)localIterator.next();
          if (!localb.url.equals(paramb.url)) {
            continue;
          }
          if (paramb.bNI) {}
          try
          {
            System.currentTimeMillis();
            if (paramb.type == 6)
            {
              new File(paramb.fileName);
              adjg.fn(paramb.fileName, adiz.sC());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.ux.remove(localb);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localb.url);
              break;
              if (paramb.type != 7) {
                break label268;
              }
              adjg.fn(paramb.fileName, adiz.jN(paramb.md5));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramb.fileName).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.a != null) {
              this.a.Gl(false);
            }
            this.b.uo();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.ux.size() != 0) {
        for (;;)
        {
          adja.b localb;
          File localFile = new File(paramb.fileName);
          adjg.fn(paramb.fileName, localFile.getParentFile().getAbsolutePath() + File.separator + paramb.md5 + File.separator);
        }
      }
      if (this.a != null) {
        this.a.Gl(true);
      }
      this.b.uo();
      return;
    }
    if (this.a != null) {
      this.a.Gl(false);
    }
    this.b.uo();
  }
  
  public void aj(long paramLong1, long paramLong2)
  {
    if (this.a != null) {
      this.a.KV(adjd.a(this.b, paramLong1, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */