import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class atmh
  extends auvp
  implements View.OnClickListener, atiw.a
{
  private List<atmh.a> KD;
  private atil a;
  private Activity mActivity;
  
  public atmh(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.a = new atil.a(null, this).a(this).a();
  }
  
  private void a(String paramString, int paramInt, atmh.b paramb)
  {
    paramb.a.setDefaultImage(athu.hL(paramInt));
    if (!aueh.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      paramb.a.setAsyncImage(paramString);
      return;
    case 5: 
      paramb.a.setApkIconAsyncImage(paramString);
      return;
    }
    paramb.a.setAsyncImage(paramString);
  }
  
  public void b(int paramInt, Object paramObject, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UploadingFileListAdapter", 2, "delete upload file");
    }
    paramView = new ArrayList(1);
    paramView.add(Long.valueOf(((atmh.a)paramObject).taskId));
    atgi.a().deleteUploadFile(paramView);
  }
  
  public int getCount()
  {
    if (this.KD != null) {
      return this.KD.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.KD.size() != 0) {
      return (atmh.a)this.KD.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    atmh.b localb;
    atmh.a locala;
    DecimalFormat localDecimalFormat;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mActivity).inflate(2131558992, null);
      paramView.setTag(new atmh.b(paramView));
      localObject = new auvd.a();
      paramView = this.a.a(this.mActivity, paramView, (auvd.a)localObject, -1);
      paramView.setTag(localObject);
      this.a.a(this.mActivity, paramView, paramInt, this.KD.get(paramInt), (auvd.a)localObject);
      localb = (atmh.b)((auvd.a)localObject).Lz.getTag();
      locala = (atmh.a)this.KD.get(paramInt);
      localDecimalFormat = new DecimalFormat("#.##");
      if (locala.uploadStatus != 1) {
        break label584;
      }
      localb.k.setClickable(true);
      localb.k.setVisibility(0);
      localb.k.setSelected(false);
      if (locala.ayl <= 1048576.0D) {
        break label538;
      }
      localObject = localDecimalFormat.format(locala.ayl / 1048576.0D);
      localb.afb.setText((String)localObject + "MB/s");
      label221:
      if (QLog.isColorLevel()) {
        QLog.i("UploadingFileListAdapter", 2, "update speed " + locala.ayl + "  " + (String)localObject);
      }
      localb.afa.setVisibility(0);
      localb.fileSize.setVisibility(0);
      localb.afb.setTextColor(this.mActivity.getResources().getColor(2131165552));
      localb.ay.setProgressDrawable(this.mActivity.getResources().getDrawable(2130839431));
      localb.Ky.setVisibility(0);
      label334:
      localb.k.setOnClickListener(this);
      localb.k.setTag(locala);
      localb.afa.setText(localDecimalFormat.format(locala.progress / 1048576.0D) + "MB/");
      localb.ay.setMax((int)locala.ayk);
      localb.ay.setProgress((int)locala.progress);
      if (locala.fileType != 0) {
        break label1339;
      }
      if (locala.thumbPath == null) {
        break label1128;
      }
      a(locala.thumbPath, locala.fileType, localb);
    }
    for (;;)
    {
      localb.fileName.setText(locala.fileName);
      localb.fileSize.setText(localDecimalFormat.format(locala.ayk / 1048576.0D) + "MB");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (auvd.a)paramView.getTag();
      break;
      label538:
      localObject = String.valueOf(locala.ayl / 1024L);
      localb.afb.setText((String)localObject + "KB/s");
      break label221;
      label584:
      if (locala.uploadStatus == 0)
      {
        localb.k.setClickable(true);
        localb.k.setVisibility(0);
        localb.k.setSelected(false);
        localb.afb.setText("等待上传中...");
        localb.afa.setVisibility(8);
        localb.fileSize.setVisibility(0);
        localb.afb.setTextColor(this.mActivity.getResources().getColor(2131165552));
        localb.ay.setProgressDrawable(this.mActivity.getResources().getDrawable(2130839431));
        localb.Ky.setVisibility(0);
        break label334;
      }
      if (locala.uploadStatus == 3)
      {
        localb.k.setClickable(true);
        localb.k.setVisibility(0);
        localb.k.setSelected(true);
        localb.afb.setText("已暂停");
        localb.afa.setVisibility(4);
        localb.fileSize.setVisibility(4);
        localb.afb.setTextColor(this.mActivity.getResources().getColor(2131165552));
        localb.ay.setProgressDrawable(this.mActivity.getResources().getDrawable(2130839430));
        localb.Ky.setVisibility(0);
        break label334;
      }
      if (locala.uploadStatus != 4) {
        break label334;
      }
      localb.k.setVisibility(0);
      localb.k.setSelected(true);
      localb.k.setClickable(true);
      localb.afb.setText("添加失败");
      localb.afb.setTextColor(this.mActivity.getResources().getColor(2131167179));
      localb.afa.setVisibility(4);
      localb.fileSize.setVisibility(4);
      localb.ay.setProgressDrawable(this.mActivity.getResources().getDrawable(2130839430));
      localb.Ky.setVisibility(0);
      switch (locala.errCode)
      {
      default: 
        if ((locala.errMsg != null) && (!locala.errMsg.equals(""))) {
          localb.afb.setText(locala.errMsg);
        }
        break;
      case 1127: 
      case 22000: 
        localb.afb.setText("日上传总量超限，添加失败。");
        break;
      case 1053: 
      case 22081: 
        localb.afb.setText("云文件容量不足，添加失败");
        break;
      case 3: 
        localb.afb.setText("已暂停");
        localb.afb.setTextColor(this.mActivity.getResources().getColor(2131165552));
        break;
      case -101: 
        localb.afb.setText("添加失败，请稍后重试");
        break;
        localb.afb.setText("添加失败");
        break;
        label1128:
        localObject = aqhs.bytes2HexStr(audx.t(locala.filePath));
        if (localObject == null)
        {
          QLog.d("UploadingFileListAdapter", 1, "thumb name is null, filepath " + locala.filePath);
          a(locala.filePath, locala.fileType, localb);
        }
        else
        {
          localObject = ((String)localObject).toUpperCase();
          localObject = audn.a().wb() + auef.D(5, (String)localObject);
          if (aueh.fileExistsAndNotEmpty((String)localObject))
          {
            QLog.d("UploadingFileListAdapter", 1, "thumb is exist " + (String)localObject);
            locala.thumbPath = ((String)localObject);
            a(locala.thumbPath, locala.fileType, localb);
          }
          else
          {
            QLog.d("UploadingFileListAdapter", 1, "thumb is not exist " + (String)localObject);
            a(locala.filePath, locala.fileType, localb);
            continue;
            label1339:
            a(locala.filePath, locala.fileType, localb);
          }
        }
        break;
      }
    }
  }
  
  public void nL(List<atmh.a> paramList)
  {
    this.KD = paramList;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArrayList localArrayList = new ArrayList(1);
      atmh.a locala = (atmh.a)paramView.getTag();
      localArrayList.add(Long.valueOf(locala.taskId));
      if ((locala.uploadStatus == 1) || (locala.uploadStatus == 0)) {
        atgi.a().stopUploadFile(localArrayList, 3);
      } else if ((locala.uploadStatus == 3) || (locala.uploadStatus == 4)) {
        if (audx.amK()) {
          ahal.a(paramView.getContext(), 2131693826, 2131693829, new atmi(this, localArrayList));
        } else {
          atgi.a().startUploadFile(localArrayList);
        }
      }
    }
  }
  
  public static class a
  {
    public long ayk = 0L;
    public long ayl = 0L;
    public int errCode = 0;
    public String errMsg;
    String fileName;
    String filePath;
    int fileType;
    public long progress = 0L;
    public long taskId;
    String thumbPath;
    public int uploadStatus = 0;
    int uploadType = 0;
    
    a(FileManagerEntity paramFileManagerEntity)
    {
      this.taskId = paramFileManagerEntity.uploadFile.taskId;
      this.ayk = paramFileManagerEntity.fileSize;
      this.errCode = paramFileManagerEntity.uploadFile.result;
      this.errMsg = paramFileManagerEntity.uploadFile.resultMsg;
      this.uploadType = paramFileManagerEntity.uploadFile.uploadType;
      this.progress = paramFileManagerEntity.uploadFile.progressSize;
      this.fileName = paramFileManagerEntity.fileName;
      this.uploadStatus = paramFileManagerEntity.uploadFile.uploadStatus;
      this.fileType = paramFileManagerEntity.nFileType;
      this.filePath = paramFileManagerEntity.uploadFile.uploadPath;
      this.thumbPath = paramFileManagerEntity.strThumbPath;
    }
  }
  
  class b
  {
    View Ky;
    AsyncImageView a;
    TextView afa;
    TextView afb;
    ProgressBar ay;
    TextView fileName;
    TextView fileSize;
    FixSizeImageView k;
    
    b(View paramView)
    {
      this.a = ((AsyncImageView)paramView.findViewById(2131368997));
      this.fileName = ((TextView)paramView.findViewById(2131380610));
      this.fileName.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.fileSize = ((TextView)paramView.findViewById(2131380607));
      this.afa = ((TextView)paramView.findViewById(2131380608));
      this.afb = ((TextView)paramView.findViewById(2131380609));
      this.ay = ((ProgressBar)paramView.findViewById(2131364816));
      this.k = ((FixSizeImageView)paramView.findViewById(2131364817));
      this.Ky = paramView.findViewById(2131373698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmh
 * JD-Core Version:    0.7.0.1
 */