import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atkf
  extends atjr
{
  public atkf(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    label238:
    FileManagerEntity localFileManagerEntity;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558964, null);
      paramViewGroup = new atkf.a(null);
      paramViewGroup.g = ((AsyncImageView)paramView.findViewById(2131364710));
      paramViewGroup.h = ((AsyncImageView)paramView.findViewById(2131364720));
      paramViewGroup.aeL = ((TextView)paramView.findViewById(2131364718));
      paramViewGroup.aeM = ((TextView)paramView.findViewById(2131364717));
      paramViewGroup.aeO = ((TextView)paramView.findViewById(2131364716));
      paramViewGroup.ab = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.aeQ = ((TextView)paramView.findViewById(2131364709));
      paramViewGroup.j = ((FixSizeImageView)paramView.findViewById(2131364708));
      paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131364719));
      paramViewGroup.Kw = paramView.findViewById(2131367356);
      paramViewGroup.g.setAsyncClipSize(wja.dp2px(36.0F, this.context.getResources()), wja.dp2px(36.0F, this.context.getResources()));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setTag(paramViewGroup);
      if (!paramBoolean1) {
        break label803;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
      localFileManagerEntity = (FileManagerEntity)paramatiu;
      paramViewGroup.a = paramatiu;
      paramViewGroup.isSelected = paramBoolean2;
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.g.setOnClickListener(paramOnClickListener);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      athu.d(paramViewGroup.g, localFileManagerEntity);
      paramViewGroup.h.setVisibility(8);
      if ((audx.fM(localFileManagerEntity.fileName) == 2) && (aqhq.fileExistsAndNotEmpty(athu.j(localFileManagerEntity)))) {
        paramViewGroup.h.setVisibility(0);
      }
      paramatiu = "";
      if (localFileManagerEntity.cloudFile != null)
      {
        paramInt1 = 0;
        if (localFileManagerEntity.cloudFile.clusterFileList != null) {
          paramInt1 = localFileManagerEntity.cloudFile.clusterFileList.size();
        }
        paramatiu = athu.a(this.app, this.context, localFileManagerEntity.cloudFile.aioRecentFileExt, localFileManagerEntity.cloudFile.bIsClusterFile, paramInt1);
      }
      paramOnLongClickListener = localFileManagerEntity.fileName;
      paramViewGroup.aeL.setText(paramOnLongClickListener);
      if ((this.entrance != 2) && (this.entrance != 0)) {
        break label816;
      }
      paramViewGroup.aeM.setText(auqb.cq(localFileManagerEntity.getSortTime()) + " " + paramatiu + " ");
      label487:
      paramViewGroup.aeO.setText(athu.c((float)localFileManagerEntity.fileSize));
      if ((localFileManagerEntity.cloudFile == null) || (localFileManagerEntity.cloudFile.expireTime == 0) || (aqhq.fileExists(localFileManagerEntity.getFilePath()))) {
        break label886;
      }
      paramViewGroup.aeQ.setVisibility(0);
      paramViewGroup.aeQ.setText(athu.a(localFileManagerEntity.cloudFile));
      if (!paramBoolean1) {
        break label862;
      }
      paramViewGroup.aeM.setMaxWidth(wja.dp2px(120.0F, this.context.getResources()));
    }
    for (;;)
    {
      if (this.entrance == 2)
      {
        paramView.setMinimumHeight(aqcx.dip2px(this.app.getApp(), 60.0F));
        paramatiu = (RelativeLayout.LayoutParams)paramViewGroup.aeL.getLayoutParams();
        paramatiu.setMargins(0, 0, aqcx.dip2px(this.app.getApp(), 32.0F), 0);
        paramViewGroup.aeL.setLayoutParams(paramatiu);
        paramInt1 = localFileManagerEntity.status;
        paramViewGroup.j.setTag(paramViewGroup);
        if (paramInt1 != 2) {
          break label920;
        }
        paramViewGroup.j.setOnClickListener(paramOnClickListener);
        paramViewGroup.Kw.setVisibility(0);
        paramViewGroup.j.setVisibility(0);
        paramViewGroup.progressBar.setVisibility(0);
        paramViewGroup.progressBar.setMax((int)localFileManagerEntity.fileSize);
        paramInt2 = (int)((float)localFileManagerEntity.fileSize * localFileManagerEntity.getfProgress());
        paramViewGroup.progressBar.setProgress(paramInt2);
        if (QLog.isColorLevel()) {
          QLog.i("FileCloudFileItemBuilder", 2, localFileManagerEntity.fileName + " status " + paramInt1);
        }
      }
      return paramView;
      paramViewGroup = (atkf.a)paramView.getTag();
      break;
      label803:
      paramViewGroup.ab.setVisibility(8);
      break label238;
      label816:
      paramViewGroup.aeM.setText(auqb.bG(localFileManagerEntity.getSortTime()) + " " + paramatiu + " ");
      break label487;
      label862:
      paramViewGroup.aeM.setMaxWidth(wja.dp2px(160.0F, this.context.getResources()));
      continue;
      label886:
      paramViewGroup.aeQ.setVisibility(8);
      paramViewGroup.aeM.setMaxWidth(wja.dp2px(200.0F, this.context.getResources()));
    }
    label920:
    paramViewGroup.j.setOnClickListener(null);
    paramViewGroup.j.setVisibility(8);
    paramViewGroup.progressBar.setVisibility(4);
    paramViewGroup.Kw.setVisibility(4);
    return paramView;
  }
  
  public List<atiw> a(atiu paramatiu)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    if (((paramatiu instanceof FileManagerEntity)) && (!Arrays.equals(((atgc)this.app.getManager(373)).aF(), ((FileManagerEntity)paramatiu).pDirKey))) {
      localArrayList.add(c);
    }
    localArrayList.add(b);
    return localArrayList;
  }
  
  public void destroy() {}
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(c);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends atjv.a
  {
    View Kw;
    CheckBox ab;
    TextView aeL;
    TextView aeM;
    TextView aeO;
    TextView aeQ;
    AsyncImageView g;
    AsyncImageView h;
    FixSizeImageView j;
    ProgressBar progressBar;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkf
 * JD-Core Version:    0.7.0.1
 */