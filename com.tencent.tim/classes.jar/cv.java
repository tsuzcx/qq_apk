import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cv
  extends BaseAdapter
{
  private final int TYPE_COUNT = 2;
  private DataLineMsgSet a;
  private QQAppInterface app;
  private DLFilesViewerActivity b;
  public View.OnClickListener c = new cx(this);
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener mOnClickListener = new cw(this);
  
  public cv(Context paramContext, DataLineMsgSet paramDataLineMsgSet, DLFilesViewerActivity paramDLFilesViewerActivity, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.a = paramDataLineMsgSet;
    this.b = paramDLFilesViewerActivity;
    this.app = paramQQAppInterface;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public static DLFileInfo a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DLFileInfo localDLFileInfo = new DLFileInfo();
    localDLFileInfo.fileName = paramDataLineMsgRecord.filename;
    localDLFileInfo.fileSize = paramDataLineMsgRecord.filesize;
    localDLFileInfo.localPath = paramDataLineMsgRecord.path;
    localDLFileInfo.sessionid = paramDataLineMsgRecord.sessionid;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      if (!paramDataLineMsgRecord.issuc)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.state = 1;
          return localDLFileInfo;
        }
        localDLFileInfo.state = 4;
        return localDLFileInfo;
      }
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          localDLFileInfo.state = 0;
          return localDLFileInfo;
        }
        localDLFileInfo.state = 3;
        return localDLFileInfo;
      }
      localDLFileInfo.state = 5;
      return localDLFileInfo;
    }
    if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        localDLFileInfo.state = 1;
        return localDLFileInfo;
      }
      localDLFileInfo.state = 4;
      return localDLFileInfo;
    }
    localDLFileInfo.state = 2;
    return localDLFileInfo;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.strMoloKey != null)
    {
      acde localacde = (acde)this.app.getBusinessHandler(8);
      if ((!paramDataLineMsgRecord.bIsApkFile) || (paramDataLineMsgRecord.nAppStatus == 1))
      {
        int i = localacde.open(paramDataLineMsgRecord.strMoloKey);
        if (i == 2) {
          ahao.OS(2131694128);
        }
        while (i == 0) {
          return;
        }
        ahao.OS(2131695388);
        return;
      }
      localacde.z(paramDataLineMsgRecord.strMoloKey);
      return;
    }
    paramDataLineMsgRecord = paramDataLineMsgRecord.path;
    ahav.F(this.b, paramDataLineMsgRecord);
  }
  
  private void a(cv.a parama, DataLineMsgRecord paramDataLineMsgRecord)
  {
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (paramDataLineMsgRecord.strMoloKey != null) {
      localacde.F(111);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramDataLineMsgRecord.sessionid));
    if (localacde.af(localArrayList))
    {
      parama.a.state = 3;
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.app.b().a(i).ig(paramDataLineMsgRecord.msgId);
      paramDataLineMsgRecord.issuc = true;
      return;
    }
    ahao.OS(2131695433);
  }
  
  private void b(cv.a parama, DataLineMsgRecord paramDataLineMsgRecord)
  {
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (parama.nFileType == 0) {
      localacde.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    for (;;)
    {
      parama.a.state = 0;
      return;
      localacde.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if ((paramListView == null) || (paramLong == 0L)) {
      return;
    }
    Object localObject = this.a.values().iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if ((localDataLineMsgRecord == null) || (localDataLineMsgRecord.sessionid != paramLong)) {}
      }
      else
      {
        paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
        if ((paramListView == null) || (i >= this.a.getTotalCount())) {
          break;
        }
        localObject = this.a.getItemBySessionId(paramLong);
        if (localObject == null) {
          break;
        }
        float f = paramFloat;
        if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
          f = ((DataLineMsgRecord)localObject).progress;
        }
        localObject = (ProgressBar)paramListView.findViewById(2131367035);
        if (localObject != null) {
          ((ProgressBar)localObject).setProgress((int)(f * 100.0F));
        }
        paramListView = (TextView)paramListView.findViewById(2131367075);
        if (paramListView == null) {
          break;
        }
        i = (int)(f * 100.0F);
        paramListView.setText(String.valueOf(i) + "%");
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.a.getComeCount() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt == getCount() - 1) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return this.a.values().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      return 1;
    }
    return 0;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (paramInt == getCount() - 1)
    {
      i = 1;
      if (i != 0) {
        break label929;
      }
    }
    label649:
    label787:
    label929:
    for (Object localObject = (DataLineMsgRecord)getItem(paramInt);; localObject = null)
    {
      cv.a locala;
      label89:
      View localView;
      if (paramView == null)
      {
        locala = new cv.a();
        if (i != 0)
        {
          paramView = this.mInflater.inflate(2131559181, null);
          locala.y = ((ImageView)paramView.findViewById(2131366493));
          locala.b = ((WaitTextView)paramView.findViewById(2131366495));
          paramView.setTag(locala);
          localView = paramView;
          paramView = locala;
          label101:
          if (i == 0) {
            break label553;
          }
          if (this.a.getComeCount() != this.a.getTotalCount()) {
            break label362;
          }
          localView.setVisibility(4);
          paramView.b.co();
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        i = 0;
        break;
        paramView = this.mInflater.inflate(2131559180, null);
        locala.n = ((RelativeLayout)paramView.findViewById(2131367057));
        locala.n.setOnClickListener(this.mOnClickListener);
        locala.n.setTag(locala);
        locala.c = ((AsyncImageView)paramView.findViewById(2131367022));
        locala.c.setDefaultImage(2130845068);
        locala.c.setIsDrawRound(false);
        locala.mFileName = ((TextView)paramView.findViewById(2131367070));
        locala.mFileSize = ((TextView)paramView.findViewById(2131367074));
        locala.M = ((TextView)paramView.findViewById(2131367075));
        locala.f = ((ProgressBar)paramView.findViewById(2131367035));
        locala.B = ((Button)paramView.findViewById(2131361959));
        locala.B.setTag(locala);
        locala.B.setOnClickListener(this.c);
        break label89;
        locala = (cv.a)paramView.getTag();
        localView = paramView;
        paramView = locala;
        break label101;
        label362:
        int j;
        if (!this.a.isTimeOut())
        {
          paramView.y.setVisibility(8);
          paramView.b.setVisibility(0);
          i = this.a.getComeCount();
          j = this.a.getTotalCount();
          localObject = String.format(this.app.getApp().getString(2131695425), new Object[] { Integer.valueOf(j - i) });
          paramView.b.setWaitText((String)localObject);
          paramView.b.cn();
        }
        else
        {
          paramView.b.co();
          paramView.y.setVisibility(0);
          paramView.b.setVisibility(0);
          i = this.a.getComeCount();
          j = this.a.getTotalCount();
          localObject = String.format(this.app.getApp().getString(2131695423), new Object[] { Integer.valueOf(i), Integer.valueOf(j - i) });
          paramView.b.setWaitText((String)localObject);
          continue;
          label553:
          if (localObject != null) {
            break label577;
          }
          paramView.f.setVisibility(4);
          paramView.B.setVisibility(4);
        }
      }
      label577:
      paramView.f.setVisibility(0);
      paramView.B.setVisibility(0);
      paramView.a = a((DataLineMsgRecord)localObject);
      paramView.nFileType = ((DataLineMsgRecord)localObject).msgtype;
      if ((((DataLineMsgRecord)localObject).strMoloKey != null) && (((DataLineMsgRecord)localObject).bIsApkFile))
      {
        paramView.c.setDefaultImage(2130845068);
        paramView.c.setAsyncImage(((DataLineMsgRecord)localObject).strMoloIconUrl);
        paramView.mFileName.setText(((DataLineMsgRecord)localObject).filename);
        paramView.mFileSize.setText(dx.g(((DataLineMsgRecord)localObject).filesize));
        if ((((DataLineMsgRecord)localObject).progress != 1.0F) && (((DataLineMsgRecord)localObject).issuc) && (((DataLineMsgRecord)localObject).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject).fileMsgStatus != 2L)) {
          break label848;
        }
        paramView.f.setVisibility(4);
        paramView.M.setVisibility(4);
        if ((((DataLineMsgRecord)localObject).issuc) && (((DataLineMsgRecord)localObject).fileMsgStatus != 1L) && (((DataLineMsgRecord)localObject).fileMsgStatus != 2L)) {
          break label787;
        }
        paramView.B.setText(2131695434);
      }
      for (;;)
      {
        break;
        ahav.a(paramView.c, (DataLineMsgRecord)localObject);
        break label649;
        if (((DataLineMsgRecord)localObject).progress == 1.0F) {
          if ((((DataLineMsgRecord)localObject).strMoloKey == null) || (!((DataLineMsgRecord)localObject).bIsApkFile) || (((DataLineMsgRecord)localObject).nAppStatus == 1))
          {
            paramView.B.setText(2131695422);
          }
          else
          {
            paramView.B.setText(2131695408);
            continue;
            label848:
            paramView.f.setVisibility(0);
            paramView.M.setVisibility(0);
            i = (int)(((DataLineMsgRecord)localObject).progress * 100.0F);
            paramView.f.setProgress(i);
            paramView.M.setText(String.valueOf(i) + "%");
            paramView.B.setText(2131695426);
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public class a
    implements Cloneable
  {
    public Button B;
    public TextView M;
    public DLFileInfo a;
    public WaitTextView b;
    public AsyncImageView c;
    public ProgressBar f;
    public TextView mFileName;
    public TextView mFileSize;
    public RelativeLayout n;
    int nFileType;
    public ImageView y;
    
    public a() {}
    
    public Object clone()
    {
      try
      {
        localObject = super.clone();
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        do
        {
          Object localObject = this;
        } while (!QLog.isColorLevel());
        QLog.d("DatalineFilesAdapter", 2, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */