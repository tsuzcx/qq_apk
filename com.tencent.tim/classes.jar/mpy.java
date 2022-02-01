import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class mpy
{
  private mir.a jdField_a_of_type_Mir$a;
  private miw jdField_a_of_type_Miw = new miw();
  private mpt jdField_a_of_type_Mpt = new mpt();
  private mpu jdField_a_of_type_Mpu;
  private mqh jdField_a_of_type_Mqh = new mqh();
  private Activity activity;
  private URLDrawable e;
  
  public mpy(Activity paramActivity, mpu parammpu)
  {
    this.activity = paramActivity;
    this.jdField_a_of_type_Mpu = parammpu;
    init();
  }
  
  private void aRg()
  {
    URL localURL = aqfy.generateAlbumVideoThumbURL(this.jdField_a_of_type_Mir$a.path, null);
    this.jdField_a_of_type_Mir$a.coverPath = aoiz.getFilePath(localURL.toString());
    if (new File(this.jdField_a_of_type_Mir$a.coverPath).exists())
    {
      aRi();
      return;
    }
    this.e = URLDrawable.getDrawable(localURL, null);
    if (this.e.getStatus() == 1)
    {
      b(aqhu.drawableToBitmap(this.e.getCurrDrawable()), this.jdField_a_of_type_Mir$a.coverPath);
      return;
    }
    this.e.setURLDrawableListener(new mqf(this));
    this.e.startDownload();
  }
  
  private void aRh()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Mir$a == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Mpu.getDataCount()) {
        break label76;
      }
      mir.a locala = this.jdField_a_of_type_Mpu.a(i);
      if (this.jdField_a_of_type_Mpt.a(locala, null))
      {
        this.jdField_a_of_type_Mpu.rW(i);
        return;
        i = 0;
        break;
      }
      i += 1;
    }
    label76:
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
    }
    QQToast.a(this.activity, 2131696364, 1).show();
  }
  
  private void aRi()
  {
    int i = 0;
    ColumnInfo localColumnInfo = null;
    Intent localIntent = this.activity.getIntent();
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("key_from", 0);
      localColumnInfo = (ColumnInfo)localIntent.getParcelableExtra("key_column_info");
    }
    EditVideoFragment.a(this.activity, this.jdField_a_of_type_Mir$a, localColumnInfo, i, 10001);
  }
  
  private void aRj()
  {
    QQToast.a(this.activity, "请选择一个视频", 0).show();
  }
  
  private void b(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new mpv(paramBitmap, paramString);
    paramBitmap.setDownloadListener(new mqg(this));
    paramBitmap.startDownload();
  }
  
  private void init()
  {
    this.jdField_a_of_type_Mpt.a("暂不支持该类视频格式", new mpz(this));
    this.jdField_a_of_type_Mpt.a("视频时长短于5秒，无法上传", new mqa(this));
    this.jdField_a_of_type_Mpt.a("视频文件不存在", new mqb(this));
    String str = "视频大小超过" + ncg.kE() + "，无法上传";
    this.jdField_a_of_type_Mpt.a(str, new mqc(this));
    this.jdField_a_of_type_Miw.a(new mqd(this));
  }
  
  public mqh a()
  {
    return this.jdField_a_of_type_Mqh;
  }
  
  public boolean a(mir.a parama)
  {
    return this.jdField_a_of_type_Mpt.a(parama, new mqe(this));
  }
  
  public void aPh()
  {
    this.jdField_a_of_type_Miw.aPh();
  }
  
  public void aRf()
  {
    if (this.jdField_a_of_type_Mir$a == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    aRg();
  }
  
  public void d(mir.a parama)
  {
    this.jdField_a_of_type_Mir$a = parama;
    this.jdField_a_of_type_Mqh.e(parama);
  }
  
  public void rP(int paramInt)
  {
    this.jdField_a_of_type_Miw.rP(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpy
 * JD-Core Version:    0.7.0.1
 */