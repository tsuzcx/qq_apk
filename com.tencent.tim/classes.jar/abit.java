import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class abit
  extends aquy
{
  abit(abis paramabis, File paramFile, abis.a parama) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + paramaquz.getStatus());
    }
    if (3 == paramaquz.getStatus())
    {
      if (this.ac.exists())
      {
        String str = this.a.qZ();
        paramaquz = this.a.qU();
        if (BspatchUtil.D(str, this.ac.getAbsolutePath(), paramaquz))
        {
          try
          {
            str = arwv.encodeFileHexStr(paramaquz);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.a.mMd5);
            }
            if (abis.b(this.a, str))
            {
              if (abis.b(this.a))
              {
                jqp.b(new File(paramaquz), this.ac.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.ac.getAbsolutePath() + " dstpath:" + paramaquz);
                }
              }
              for (;;)
              {
                abis.a(this.this$0, this.a.cpj, this.a);
                return;
                boolean bool = aqhq.copyFile(paramaquz, this.a.qX() + this.a.bgw);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.ac.getAbsolutePath() + paramaquz.getMessage());
          }
          catch (Exception paramaquz)
          {
            this.ac.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.ac.getAbsolutePath() + paramaquz.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            abis.a(this.this$0, this.a);
            return;
          }
          catch (OutOfMemoryError paramaquz)
          {
            this.ac.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
        else
        {
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile error path->" + this.ac.getAbsolutePath());
          abis.a(this.this$0, this.a);
        }
      }
      else
      {
        abis.a(this.this$0, this.a);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.ac.getAbsolutePath() + " task.getStatus()->" + paramaquz.getStatus());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.ac.getAbsolutePath() + " task.getStatus()->" + paramaquz.getStatus());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abit
 * JD-Core Version:    0.7.0.1
 */