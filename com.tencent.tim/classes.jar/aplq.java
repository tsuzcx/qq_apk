import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class aplq
  extends aple
{
  protected String cpV;
  protected Map<apkv, Stream<apkv>> nJ;
  
  public aplq(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public aplq.a a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560811, paramViewGroup, false);
    aplq.a locala = new aplq.a(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(locala.hashCode()) });
    }
    b(locala.j, locala);
    b(locala.dy, locala);
    b(locala.EB, locala);
    b(locala.kN, locala);
    if (this.e.Ls() != 0) {
      paramViewGroup.setPadding(this.e.Ls(), 0, this.e.Ls(), 0);
    }
    return locala;
  }
  
  protected SimpleObserver<apks> a(apks paramapks)
  {
    return new aplr(this, paramapks);
  }
  
  protected SimpleObserver<apkv> a(apkv paramapkv)
  {
    return new apls(this, paramapkv);
  }
  
  public void a(View paramView, aple.a parama)
  {
    apkv localapkv = (apkv)parama.a;
    switch (paramView.getId())
    {
    case 2131368585: 
    default: 
    case 2131368582: 
    case 2131368586: 
      do
      {
        return;
        this.a.h(parama);
        return;
      } while (localapkv.mUploadStatus != 2);
      parama.EB.setVisibility(4);
      c(localapkv);
      return;
    }
    aurd.cE((Activity)this.e.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localapkv.mPosition), ", path=", localapkv.mVideoPath });
    }
    a(localapkv);
  }
  
  protected void a(apks paramapks)
  {
    paramapks = (apkv)paramapks;
    if (this.nI == null) {
      this.nI = new LinkedHashMap();
    }
    if (this.nJ == null) {
      this.nJ = new LinkedHashMap();
    }
    Stream localStream1 = paramapks.b(this.e);
    if ((localStream1 != null) && (!this.nJ.containsKey(paramapks))) {
      this.nJ.put(paramapks, localStream1);
    }
    Stream localStream2 = paramapks.a(this.e);
    if (!this.nI.containsKey(paramapks)) {
      this.nI.put(paramapks, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.cpV))
      {
        this.cpV = paramapks.cpR;
        paramapks.arF = System.currentTimeMillis();
        localStream1.subscribe(a(paramapks));
      }
    }
    while (!TextUtils.isEmpty(this.cpU)) {
      return;
    }
    this.cpU = paramapks.cpR;
    this.cRi = true;
    paramapks.arF = System.currentTimeMillis();
    localStream2.subscribe(a(paramapks));
  }
  
  public void a(apkv paramapkv)
  {
    if (this.e.getShowType() == 0) {
      this.e.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.e.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", paramapkv.Bs());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    paramapkv = new Intent();
    paramapkv.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    paramapkv.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(paramapkv);
  }
  
  protected void a(aple.a parama, apks paramapks, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parama.dy.setVisibility(4);
      parama.kN.setVisibility(0);
      parama.EB.setVisibility(4);
      parama.d.setVisibility(4);
    }
    do
    {
      return;
      parama.dy.setVisibility(0);
      switch (paramapks.mUploadStatus)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parama.d.setVisibility(0);
        parama.d.setDrawStatus(1);
        parama.d.setAnimProgress(paramapks.mProgress, paramapks.cpR);
        parama.EB.setVisibility(4);
        parama.kN.setVisibility(4);
        return;
      }
    } while (paramapks.mProgress != 100);
    parama.eaA();
    return;
    parama.d.setVisibility(4);
    parama.EB.setVisibility(0);
    parama.kN.setVisibility(4);
  }
  
  protected void cb(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      super.cb(paramInt, paramBoolean);
    }
    do
    {
      Object localObject;
      Stream localStream;
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        localObject = this.nJ.keySet().iterator();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
        }
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localObject = (apkv)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((apkv)localObject).mPosition), ", type=", Integer.valueOf(((apkv)localObject).getType()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.nJ.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.cpV = ((apkv)localObject).cpR;
      ((apkv)localObject).arF = System.currentTimeMillis();
      localStream.subscribe(a((apkv)localObject));
      return;
      this.cpV = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.cRi) });
      }
    } while (this.cRi);
    cb(0, true);
  }
  
  public void f(apkn paramapkn)
  {
    super.f(paramapkn);
    paramapkn = (apkv)paramapkn;
    if ((this.nJ != null) && (!this.nJ.isEmpty()))
    {
      paramapkn = (Stream)this.nJ.get(paramapkn);
      if (paramapkn != null) {
        paramapkn.cancel();
      }
    }
  }
  
  public void release()
  {
    super.release();
    if ((this.nJ != null) && (!this.nJ.isEmpty()))
    {
      Iterator localIterator = this.nJ.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (apkv)localIterator.next();
        localObject = (Stream)this.nJ.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.nJ.clear();
    }
  }
  
  public static class a
    extends aple.a
  {
    public a(View paramView)
    {
      super();
    }
    
    protected void eaA()
    {
      this.d.setVisibility(4);
      this.kN.setVisibility(0);
      this.EB.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplq
 * JD-Core Version:    0.7.0.1
 */