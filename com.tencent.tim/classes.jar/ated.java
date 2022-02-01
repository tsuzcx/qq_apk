import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.AutoSaveCloudStateGetPrg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.GridListView.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ated
  extends GridListView.b
  implements atjr.a
{
  protected List<Object> Km = new ArrayList();
  private ated.b a;
  protected auhk.e a;
  private QQAppInterface app;
  private atjx b;
  private Context context;
  private Set<String> dc = new HashSet();
  private Set<String> dd = new HashSet();
  private boolean dhs;
  private Set<Integer> dr = new HashSet();
  private int epu = -2;
  private int epv = -2;
  private int epw;
  private View.OnClickListener gp = new atef(this);
  private List<atio> ku = new ArrayList();
  private View.OnClickListener onClickListener;
  
  public ated(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, int paramInt, augx paramaugx)
  {
    this.jdField_a_of_type_Ated$b = new ated.b(null);
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.onClickListener = paramOnClickListener;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    paramOnClickListener = paramContext.getResources().getDisplayMetrics();
    float f = paramOnClickListener.density;
    this.epu = ((int)(((paramOnClickListener.widthPixels - 12.0F * f * (i + 1)) / i - 10.0F * f * 2.0F - 3.0F * f) / 2.0F));
    this.epv = ((int)(this.epu * 0.85D));
    if (QLog.isDevelopLevel()) {
      QLog.d("CloudFileGridAdapter", 4, "density:" + f + " singleItemWidth:" + this.epu + " singleItemHeight:" + this.epv);
    }
    this.b = new atjx(paramQQAppInterface, paramContext, paramaugx);
    this.jdField_a_of_type_Auhk$e = this.b.a(2);
  }
  
  private void a(ated.a parama, atio paramatio)
  {
    int j = paramatio.GW.size();
    parama.GV.setVisibility(4);
    parama.aeD.setVisibility(4);
    parama.jdField_Kn_of_type_AndroidViewView.setVisibility(8);
    if ((paramatio.dirType == 3) && (this.dr.contains(Integer.valueOf(6))))
    {
      parama.jdField_Kn_of_type_AndroidViewView.setVisibility(0);
      parama.aeG.setText(this.context.getString(2131691702));
    }
    int i = 0;
    if (i < parama.jdField_Kn_of_type_JavaUtilList.size())
    {
      AsyncImageView localAsyncImageView = (AsyncImageView)parama.jdField_Kn_of_type_JavaUtilList.get(i);
      ImageView localImageView = (ImageView)parama.Ko.get(i);
      if (i < j)
      {
        localAsyncImageView.setVisibility(0);
        a(localAsyncImageView, localImageView, (atiu)paramatio.GW.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localAsyncImageView.setVisibility(4);
      }
    }
    float f = this.context.getResources().getDisplayMetrics().density;
    if (paramatio.dirType == 4)
    {
      parama.GV.setVisibility(0);
      parama.aeD.setVisibility(4);
      parama.GV.setBackgroundResource(2130839405);
      parama.aeF.setText(2131691699);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramatio.dirType == 5)
          {
            parama.GV.setVisibility(0);
            parama.aeD.setVisibility(4);
            parama.GV.setBackgroundResource(2130839410);
            parama.aeF.setText(2131691701);
            return;
          }
          if (paramatio.dirType == 7)
          {
            parama.GV.setVisibility(0);
            parama.aeD.setVisibility(0);
            parama.aeD.setText(2131691694);
            parama.GV.setBackgroundResource(2130839398);
            parama.aeF.setVisibility(4);
            return;
          }
          if (paramatio.dirType != 2) {
            break;
          }
        } while (j != 0);
        parama.GV.setVisibility(0);
        parama.aeD.setVisibility(4);
        parama.GV.setBackgroundResource(2130839380);
        parama.aeF.setVisibility(4);
        if (!this.dhs) {
          break;
        }
      } while ((((CardHandler)this.app.getBusinessHandler(2)).a() != CardHandler.AutoSaveCloudStateGetPrg.GetSuc) || (aqmj.ac(this.app, "tim_cloudfile_autosave_flag")));
      parama.aeD.setVisibility(0);
      parama.aeD.setText(2131691594);
      return;
      parama.aeD.setVisibility(4);
      return;
    } while (j != 0);
    parama.GV.setVisibility(0);
    parama.aeD.setVisibility(4);
    parama.GV.setBackgroundResource(2130839380);
  }
  
  private void a(AsyncImageView paramAsyncImageView, ImageView paramImageView, atiu paramatiu)
  {
    if ((paramAsyncImageView == null) || (paramatiu == null) || (paramImageView == null)) {
      return;
    }
    if (paramatiu.getCloudFileType() == 2)
    {
      Object localObject1;
      if ((paramatiu instanceof FileManagerEntity))
      {
        localObject1 = athu.a((FileManagerEntity)paramatiu);
        if (((PadInfo)localObject1).type != 1) {
          break label101;
        }
        paramatiu = this.context.getResources().getDrawable(2130839415);
        label62:
        if (aurr.isValidUrl(((PadInfo)localObject1).thumbUrl)) {
          break label118;
        }
        paramAsyncImageView.setImageDrawable(paramatiu);
      }
      for (;;)
      {
        i = 0;
        if (i == 0) {
          break label606;
        }
        paramImageView.setVisibility(0);
        return;
        localObject1 = (PadInfo)paramatiu;
        break;
        label101:
        paramatiu = this.context.getResources().getDrawable(2130839416);
        break label62;
        label118:
        String str = ((PadInfo)localObject1).thumbUrl.replaceFirst("/0\\?", "/146?");
        localObject1 = atad.toMD5(((PadInfo)localObject1).domainId + ((PadInfo)localObject1).padId);
        localObject1 = audn.a().wb() + "teamwork-" + (String)localObject1;
        if (aueh.fileExistsAndNotEmpty((String)localObject1))
        {
          localObject3 = new File((String)localObject1);
          if (System.currentTimeMillis() - ((File)localObject3).lastModified() < 300000L)
          {
            paramAsyncImageView.setImageDrawable(Drawable.createFromPath((String)localObject1));
            return;
          }
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramatiu;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramatiu;
        Object localObject3 = new aoli();
        ((aoli)localObject3).businessType = 1002;
        ((URLDrawable.URLDrawableOptions)localObject1).mHttpDownloaderParams = localObject3;
        try
        {
          localObject1 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1);
          if (localObject1 != null)
          {
            if ((((URLDrawable)localObject1).getStatus() == 2) && (this.dd.remove(str))) {
              ((URLDrawable)localObject1).restartDownload();
            }
            ((URLDrawable)localObject1).setDownloadListener(new atee(this, str));
            paramAsyncImageView.setImageDrawable((Drawable)localObject1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("CloudFileGridAdapter", 2, localException, new Object[] { "loadThumbImage failed" });
            }
            Object localObject2 = null;
          }
          paramAsyncImageView.setImageDrawable(paramatiu);
        }
      }
    }
    if (paramatiu.getCloudFileType() == 0)
    {
      paramatiu = (FileManagerEntity)paramatiu;
      paramAsyncImageView.setAsyncClipSize(this.epu, this.epv);
      paramAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (paramatiu.nFileType != 2) {
        break label613;
      }
    }
    label606:
    label613:
    for (int i = 1;; i = 0)
    {
      athu.c(paramAsyncImageView, paramatiu);
      break;
      if (paramatiu.getCloudFileType() == 3)
      {
        i = 0;
        break;
      }
      if (paramatiu.getCloudFileType() == 1)
      {
        paramAsyncImageView.setImageResource(2130839413);
        i = 0;
        break;
      }
      if (paramatiu.getCloudFileType() == 7)
      {
        switch (((atlc)paramatiu).getFileType())
        {
        case 4: 
        case 5: 
        case 8: 
        default: 
          paramAsyncImageView.setImageResource(2130839406);
        }
        for (;;)
        {
          i = 0;
          break;
          paramAsyncImageView.setImageResource(2130839408);
          continue;
          paramAsyncImageView.setImageResource(2130839406);
          continue;
          paramAsyncImageView.setImageResource(2130839407);
          continue;
          paramAsyncImageView.setImageResource(2130839409);
        }
      }
      paramAsyncImageView.setImageResource(2130839421);
      i = 0;
      break;
      paramImageView.setVisibility(8);
      return;
    }
  }
  
  public void Vv(boolean paramBoolean)
  {
    this.dhs = paramBoolean;
  }
  
  public void a(int paramInt, atiu paramatiu)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Auhk$e == null);
        this.jdField_a_of_type_Auhk$e.al(new Object[] { paramatiu });
        return;
      } while (this.jdField_a_of_type_Auhk$e == null);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramatiu);
      this.jdField_a_of_type_Auhk$e.nT(localArrayList);
      return;
    } while (this.jdField_a_of_type_Auhk$e == null);
    this.jdField_a_of_type_Auhk$e.bH(paramatiu);
  }
  
  public void aak(int paramInt)
  {
    this.dr.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
  
  public void aal(int paramInt)
  {
    this.dr.remove(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
  
  public void etn()
  {
    this.dd.addAll(this.dc);
    this.dc.clear();
  }
  
  public int fK(String paramString)
  {
    int j;
    if ((this.ku == null) || (this.ku.size() == 0))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.ku.size()) {
        break label70;
      }
      j = i;
      if (((atio)this.ku.get(i)).name.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label70:
    return -1;
  }
  
  public int fT(int paramInt)
  {
    return 0;
  }
  
  public int fU(int paramInt)
  {
    return 0;
  }
  
  public List<Object> gT()
  {
    return this.Km;
  }
  
  public int getCount()
  {
    return this.ku.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.ku.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    ated.a locala;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558969, null);
      locala = new ated.a();
      locala.contentView = ((View)localObject1).findViewById(2131364732);
      locala.jdField_Kn_of_type_JavaUtilList = new ArrayList();
      locala.jdField_Kn_of_type_JavaUtilList.add((AsyncImageView)((View)localObject1).findViewById(2131364724));
      locala.jdField_Kn_of_type_JavaUtilList.add((AsyncImageView)((View)localObject1).findViewById(2131364725));
      locala.jdField_Kn_of_type_JavaUtilList.add((AsyncImageView)((View)localObject1).findViewById(2131364726));
      locala.jdField_Kn_of_type_JavaUtilList.add((AsyncImageView)((View)localObject1).findViewById(2131364727));
      locala.Ko = new ArrayList();
      locala.Ko.add((ImageView)((View)localObject1).findViewById(2131364791));
      locala.Ko.add((ImageView)((View)localObject1).findViewById(2131364792));
      locala.Ko.add((ImageView)((View)localObject1).findViewById(2131364793));
      locala.Ko.add((ImageView)((View)localObject1).findViewById(2131364794));
      localObject2 = locala.jdField_Kn_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        View localView = (View)((Iterator)localObject2).next();
        paramView = localView.getLayoutParams();
        if (paramView == null) {
          paramView = new ViewGroup.LayoutParams(this.epu, this.epv);
        }
        for (;;)
        {
          localView.setLayoutParams(paramView);
          break;
          paramView.width = this.epu;
          paramView.height = this.epv;
        }
      }
      locala.GV = ((ImageView)((View)localObject1).findViewById(2131364739));
      locala.aeD = ((TextView)((View)localObject1).findViewById(2131364743));
      locala.aeE = ((TextView)((View)localObject1).findViewById(2131364738));
      locala.aeF = ((TextView)((View)localObject1).findViewById(2131364737));
      locala.jdField_Kn_of_type_AndroidViewView = ((View)localObject1).findViewById(2131364759);
      locala.aeG = ((TextView)((View)localObject1).findViewById(2131364760));
      locala.GW = ((ImageView)((View)localObject1).findViewById(2131369738));
      locala.Km = ((View)localObject1).findViewById(2131374639);
      ((View)localObject1).setTag(locala);
      paramView = (View)localObject1;
    }
    for (;;)
    {
      this.epw = paramView.getHeight();
      localObject1 = (atio)this.ku.get(paramInt);
      locala.contentView.setTag(localObject1);
      locala.GW.setTag(localObject1);
      locala.aeE.setText(((atio)localObject1).name);
      if ((locala.Ko == null) || (locala.Ko.isEmpty())) {
        break;
      }
      localObject2 = locala.Ko.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((View)((Iterator)localObject2).next()).setVisibility(8);
      }
      locala = (ated.a)paramView.getTag();
    }
    int i = ((atio)localObject1).ar(this.app);
    Object localObject2 = MessageFormat.format(this.context.getString(2131691613), new Object[] { Integer.valueOf(i) });
    locala.aeF.setText((CharSequence)localObject2);
    locala.aeF.setVisibility(0);
    a(locala, (atio)localObject1);
    if (((atio)localObject1).dirType == 6)
    {
      locala.GW.setVisibility(0);
      locala.GW.setOnClickListener(this.gp);
    }
    for (;;)
    {
      locala.contentView.setOnClickListener(this.onClickListener);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala.GW.setVisibility(8);
      locala.contentView.setOnLongClickListener(null);
    }
  }
  
  public void nx(List<atio> paramList)
  {
    this.ku.clear();
    if (aqmj.ac(this.app, "tim_cloudfile_autosave_flag")) {
      if (paramList != null) {
        this.ku.addAll(paramList);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          atio localatio = (atio)paramList.next();
          if (localatio.dirType != 2) {
            this.ku.add(localatio);
          }
        }
      }
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (this.b != null) {
      this.b.onAccountChanged(paramQQAppInterface);
    }
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.onDestroy();
    }
  }
  
  public int zu()
  {
    return 1;
  }
  
  public static class a
  {
    public ImageView GV;
    ImageView GW;
    public View Km;
    View Kn;
    public List<AsyncImageView> Kn;
    public List<ImageView> Ko;
    public TextView aeD;
    public TextView aeE;
    public TextView aeF;
    TextView aeG;
    public View contentView;
  }
  
  class b
    implements View.OnClickListener, View.OnLongClickListener
  {
    atiu jdField_a_of_type_Atiu;
    BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    
    private b() {}
    
    private void ez(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    
    public void onClick(View paramView)
    {
      ated.this.a(paramView.getId(), this.jdField_a_of_type_Atiu);
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.isShowing()))
      {
        ez(paramView);
        return false;
      }
      this.jdField_a_of_type_Atiu = ((atiu)paramView.getTag());
      aqoa localaqoa = new aqoa();
      ated.this.Km.clear();
      ated.this.Km.add(this.jdField_a_of_type_Atiu);
      localaqoa.Z(atjr.b.hF(), ated.a(ated.this).getString(atjr.b.KB()), 2130839081);
      localaqoa.Z(atjr.c.hF(), ated.a(ated.this).getString(atjr.c.KB()), 2130839086);
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(paramView, arrayOfInt[0] + paramView.getWidth() / 2, arrayOfInt[1] + 25, localaqoa, this);
      ez(paramView);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ated
 * JD-Core Version:    0.7.0.1
 */