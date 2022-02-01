import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.1;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aple
  extends aplp<aple.a, apkn>
{
  protected boolean cRi;
  protected String cpU;
  protected Map<apks, Stream<apks>> nI;
  protected ColorDrawable p = new ColorDrawable(Color.parseColor("#DEDEDE"));
  
  public aple(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public static void D(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = paramView.getPaddingLeft() + paramView.getPaddingRight() + paramInt1;
      paramInt2 = paramView.getPaddingTop() + paramView.getPaddingBottom() + paramInt2;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label77;
      }
      if ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2))
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    return;
    label77:
    paramView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
  }
  
  private void a(apks paramapks, boolean paramBoolean)
  {
    paramapks.mMaxWidth = this.e.getWidth();
    if (this.e.Ls() > 0) {
      paramapks.mMaxWidth -= this.e.Ls() * 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result: ", Integer.valueOf(paramapks.mMaxWidth) });
    }
    if (paramBoolean) {
      this.e.getAdapter().notifyDataSetChanged();
    }
    if ((this.e.getShowType() == 0) && (paramapks.aBj())) {
      a(paramapks);
    }
  }
  
  public static boolean a(XMediaEditor paramXMediaEditor, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (localObject == null) || (((ArrayList)localObject).size() == 0); localObject = null)
    {
      QLog.e("ImageItem", 1, "selected list empty!");
      return paramBoolean;
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    int i;
    ArrayList localArrayList;
    label116:
    int j;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder().append("selected pic or video! size = ");
      if (localHashMap != null)
      {
        i = localHashMap.size();
        QLog.d("ImageItem", 2, i);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label216;
      }
      paramIntent = (String)((Iterator)localObject).next();
      if (localHashMap == null) {
        break label425;
      }
      if (aqfy.getMediaType((LocalMediaInfo)localHashMap.get(paramIntent)) != 1) {
        break label198;
      }
      j = 1;
    }
    for (;;)
    {
      label163:
      if (j != 0)
      {
        paramIntent = new apkv(paramIntent);
        i += 1;
      }
      for (;;)
      {
        localArrayList.add(paramIntent);
        break label116;
        i = 0;
        break;
        label198:
        j = 0;
        break label163;
        paramIntent = new apks(paramIntent);
      }
      label216:
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "video selected! size = ", Integer.valueOf(i), ". pic selected! size = ", Integer.valueOf(localArrayList.size() - i) });
      }
      paramIntent = paramXMediaEditor.getContext();
      if (!aqiw.isNetSupport(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, "no network toast from select media");
        }
        QQToast.a(paramIntent, 2131699442, 0).show();
        return paramBoolean;
      }
      if ((i > 0) && (!aqiw.isWifiConnected(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "no wifi. hasShownNetworkTip=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean)
        {
          aqha.a(paramIntent, 230, paramXMediaEditor.getResources().getString(2131697879), paramXMediaEditor.getResources().getString(2131697875), 2131697614, 2131697626, new aplg(paramXMediaEditor, localArrayList), new aplh()).show();
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "insertEditItemList.");
      }
      paramXMediaEditor.mP(localArrayList);
      return paramBoolean;
      label425:
      j = 0;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt4;
    arrayOfInt[1] = paramInt5;
    if ((paramInt4 > 0) && (paramInt5 > 0)) {
      if (paramInt4 > paramInt3)
      {
        arrayOfInt[0] = paramInt1;
        arrayOfInt[1] = ((int)(paramInt1 * 1.0F * paramInt5 / paramInt4));
      }
    }
    do
    {
      do
      {
        return arrayOfInt;
      } while (Math.min(paramInt4, paramInt5) >= paramInt2);
      if (paramInt4 <= paramInt5)
      {
        arrayOfInt[0] = paramInt2;
        arrayOfInt[1] = ((int)(paramInt2 * 1.0F * paramInt5 / paramInt4));
        return arrayOfInt;
      }
      arrayOfInt[0] = ((int)(paramInt2 * 1.0F * paramInt4 / paramInt5));
      arrayOfInt[1] = paramInt2;
      return arrayOfInt;
      arrayOfInt[0] = paramInt1;
      arrayOfInt[1] = ((int)(paramInt1 * 9 / 16.0F));
    } while (!QLog.isColorLevel());
    QLog.d("ImageItem", 2, new Object[] { "calculateMaxMinImageSize doudi. maxWidth=", Integer.valueOf(arrayOfInt[0]), ", height=", Integer.valueOf(arrayOfInt[1]) });
    return arrayOfInt;
  }
  
  public aple.a a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new aple.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560811, paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "Image onCreateViewHolder. vh hash=", Integer.valueOf(paramViewGroup.hashCode()) });
    }
    b(paramViewGroup.j, paramViewGroup);
    b(paramViewGroup.dy, paramViewGroup);
    b(paramViewGroup.EB, paramViewGroup);
    if (this.e.Ls() != 0) {
      paramViewGroup.itemView.setPadding(this.e.Ls(), 0, this.e.Ls(), 0);
    }
    return paramViewGroup;
  }
  
  protected SimpleObserver<apks> a(apks paramapks)
  {
    return new aplf(this, paramapks);
  }
  
  public void a(View paramView, aple.a parama)
  {
    apks localapks = (apks)parama.a;
    switch (paramView.getId())
    {
    case 2131368584: 
    case 2131368585: 
    default: 
    case 2131368582: 
    case 2131368586: 
      do
      {
        return;
        this.a.h(parama);
        return;
      } while (localapks.mUploadStatus != 2);
      parama.EB.setVisibility(4);
      c(localapks);
      return;
    }
    aurd.cE((Activity)this.e.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localapks.mPosition), ", path=", localapks.mImagePath });
    }
    apmj.O((BaseActivity)paramView.getContext(), localapks.Bq());
  }
  
  protected void a(apks paramapks)
  {
    if (this.nI == null) {
      this.nI = new LinkedHashMap();
    }
    Stream localStream = paramapks.a(this.e);
    if (!this.nI.containsKey(paramapks)) {
      this.nI.put(paramapks, localStream);
    }
    if (TextUtils.isEmpty(this.cpU))
    {
      this.cpU = paramapks.cpR;
      this.cRi = true;
      paramapks.arF = System.currentTimeMillis();
      localStream.subscribe(a(paramapks));
    }
  }
  
  public void a(aple.a parama, apkn paramapkn, int paramInt)
  {
    if (QLog.isColorLevel()) {
      if (!(paramapkn instanceof apkv)) {
        break label79;
      }
    }
    apks localapks;
    label79:
    for (Object localObject = "Video";; localObject = "Image")
    {
      QLog.d("ImageItem", 2, new Object[] { localObject, " onBindViewHolder. vh hash=", Integer.valueOf(parama.hashCode()) });
      localapks = (apks)paramapkn;
      if (localapks.mMaxWidth > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
      }
      return;
    }
    parama.d.setTag(localapks.cpR);
    int i;
    String str;
    int j;
    if (QLog.isColorLevel())
    {
      i = localapks.hashCode();
      str = localapks.cpR;
      j = localapks.mPosition;
      if (localapks.n != null) {
        break label499;
      }
      paramapkn = "null";
      label138:
      if (parama.u != null) {
        break label508;
      }
    }
    label499:
    label508:
    for (localObject = "null";; localObject = parama.u.getURL())
    {
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder. VHHash=", parama, ", infoHash=", Integer.valueOf(i), ", progressKey=", str, ", infoPosition=", Integer.valueOf(j), ", info URL=", paramapkn, ", vh URL=", localObject, ", showType=", Integer.valueOf(paramInt) });
      paramapkn = a(localapks.mMaxWidth, 200, 300, localapks.mWidth, localapks.mHeight);
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(localapks.mMaxWidth), ", infoWidth=", Integer.valueOf(localapks.mWidth), ", infoHeight=", Integer.valueOf(localapks.mHeight), ", dstWidth=", Integer.valueOf(paramapkn[0]), ", dstHeight=", Integer.valueOf(paramapkn[1]) });
      }
      D(parama.contentView, paramapkn[0], paramapkn[1]);
      a(parama, localapks, paramInt);
      if ((localapks.n == null) || (localapks.mUploadStatus == -2147483645)) {
        break label520;
      }
      localObject = parama.j.getDrawable();
      if (((localObject instanceof URLDrawable)) && (localapks.n.equals(((URLDrawable)localObject).getURL()))) {
        break;
      }
      paramapkn = URLDrawable.getDrawable(localapks.n, paramapkn[0], paramapkn[1], this.p, this.p);
      parama.j.setImageDrawable(paramapkn);
      if (paramapkn.getStatus() != 2) {
        break;
      }
      paramapkn.restartDownload();
      return;
      paramapkn = localapks.n;
      break label138;
    }
    label520:
    parama.j.setImageDrawable(this.p);
  }
  
  protected <VH extends aple.a, INFO extends apks> void a(VH paramVH, INFO paramINFO, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramVH.dy.setVisibility(4);
      paramVH.EB.setVisibility(4);
      paramVH.d.setVisibility(4);
    }
    do
    {
      return;
      paramVH.dy.setVisibility(0);
      switch (paramINFO.mUploadStatus)
      {
      default: 
        return;
      case 1: 
        paramVH.d.setVisibility(0);
        paramVH.d.setDrawStatus(1);
        paramVH.d.setAnimProgress(paramINFO.mProgress, paramINFO.cpR);
        paramVH.EB.setVisibility(4);
        return;
      case 2: 
        paramVH.d.setVisibility(4);
        paramVH.EB.setVisibility(0);
        return;
      }
    } while (paramINFO.mProgress != 100);
    paramVH.eaA();
  }
  
  public void c(apkn paramapkn)
  {
    paramapkn = (apks)paramapkn;
    if (paramapkn.aBj()) {
      a(paramapkn);
    }
  }
  
  protected void cb(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.nI.keySet().iterator();
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "scheduleStream. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
    }
    apks localapks;
    if (paramBoolean) {
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localapks = (apks)((Iterator)localObject).next();
      } while (localapks.mUploadStatus == 2);
    }
    for (;;)
    {
      if (localapks != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "scheduleStream. next info position=", Integer.valueOf(localapks.mPosition), ", type=", Integer.valueOf(localapks.getType()), ", hash=", Integer.valueOf(localapks.hashCode()) });
        }
        localObject = (Stream)this.nI.get(localapks);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, new Object[] { "scheduleStream. fire stream. info hash=", Integer.valueOf(localapks.hashCode()) });
          }
          this.cpU = localapks.cpR;
          this.cRi = true;
          localapks.arF = System.currentTimeMillis();
          ((Stream)localObject).subscribe(a(localapks));
        }
        return;
        if (((Iterator)localObject).hasNext()) {
          localapks = (apks)((Iterator)localObject).next();
        }
      }
      else
      {
        this.cpU = null;
        this.cRi = false;
        return;
      }
      localapks = null;
    }
  }
  
  public void d(apkn paramapkn)
  {
    int i = this.e.getWidth();
    if (i <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth fail result: ", Integer.valueOf(i) });
      }
      ThreadManager.getUIHandler().postDelayed(new ImageItem.1(this, paramapkn), 50L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result without post: ", Integer.valueOf(i) });
    }
    a((apks)paramapkn, false);
  }
  
  public void f(apkn paramapkn)
  {
    paramapkn = (apks)paramapkn;
    if ((this.nI != null) && (!this.nI.isEmpty()))
    {
      Stream localStream = (Stream)this.nI.get(paramapkn);
      if (localStream != null) {
        localStream.cancel();
      }
    }
    if (paramapkn.iM != null) {
      paramapkn.iM.clear();
    }
    if (paramapkn.n != null) {
      URLDrawable.removeMemoryCacheByUrl(paramapkn.n.toString());
    }
  }
  
  public void release()
  {
    if ((this.nI != null) && (!this.nI.isEmpty()))
    {
      Iterator localIterator = this.nI.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (apks)localIterator.next();
        localObject = (Stream)this.nI.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.nI.clear();
    }
  }
  
  public static class a
    extends aplc.a<apkn>
  {
    public ImageView EB;
    public View contentView;
    public MessageProgressView d;
    public ImageView dy;
    public RoundCornerImageView j;
    public ImageView kN;
    public URLDrawable u;
    
    public a(View paramView)
    {
      super();
      this.contentView = paramView.findViewById(2131368581);
      this.j = ((RoundCornerImageView)paramView.findViewById(2131368583));
      this.j.mSource = 1;
      this.j.setCorner(10);
      this.EB = ((ImageView)paramView.findViewById(2131368586));
      this.kN = ((ImageView)paramView.findViewById(2131368584));
      this.dy = ((ImageView)paramView.findViewById(2131368582));
      this.d = ((MessageProgressView)paramView.findViewById(2131368585));
      this.d.setRadius(10.0F, false);
      this.d.setShowCorner(false);
      this.d.setDisplayInTextView(wja.dp2px(17.0F, paramView.getResources()), -1);
      this.d.setAnimRunnableListener(new apli(this));
    }
    
    protected void eaA()
    {
      this.d.setVisibility(4);
      this.EB.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aple
 * JD-Core Version:    0.7.0.1
 */