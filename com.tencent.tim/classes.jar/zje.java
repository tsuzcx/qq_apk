import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zje
  extends BaseAdapter
{
  private final ChatHistoryBaseFragment a;
  private TroopManager b;
  private boolean bro;
  private SimpleDateFormat e;
  private ArrayMap<String, Boolean> i = new ArrayMap();
  private Map<String, ArrayList<TroopLinkElement>> io = new LinkedHashMap();
  private QQAppInterface mApp;
  private Context mContext;
  @NonNull
  private List<Object> uh = new ArrayList();
  private List<TroopLinkElement> ui;
  
  public zje(QQAppInterface paramQQAppInterface, Context paramContext, ChatHistoryBaseFragment paramChatHistoryBaseFragment)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramChatHistoryBaseFragment;
    this.e = new SimpleDateFormat("M月d日");
    this.ui = new ArrayList();
  }
  
  private void a(zje.b paramb, TroopLinkElement paramTroopLinkElement)
  {
    if (!TextUtils.isEmpty(paramTroopLinkElement.iconUrl))
    {
      j(zje.b.a(paramb), paramTroopLinkElement.iconUrl);
      if (TextUtils.isEmpty(paramTroopLinkElement.title)) {
        break label245;
      }
      zje.b.a(paramb).setText(paramTroopLinkElement.title);
    }
    for (;;)
    {
      Object localObject = new Date(Long.parseLong(paramTroopLinkElement.timeSecond) * 1000L);
      localObject = this.e.format((Date)localObject);
      zje.b.b(paramb).setText((CharSequence)localObject);
      this.b = ((TroopManager)this.mApp.getManager(52));
      localObject = this.b.aM(this.a.getUin(), paramTroopLinkElement.uin);
      zje.b.c(paramb).setText((CharSequence)localObject);
      zje.b.a(paramb).setOnClickListener(new zjg(this, paramTroopLinkElement, paramb));
      if (!this.bro) {
        break label259;
      }
      zje.b.a(paramb).setVisibility(0);
      boolean bool = this.ui.contains(paramTroopLinkElement);
      zje.b.a(paramb).setChecked(bool);
      paramTroopLinkElement = (LinearLayout.LayoutParams)zje.b.a(paramb).getLayoutParams();
      paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, rpq.dip2px(this.mContext, 8.0F), paramTroopLinkElement.bottomMargin);
      zje.b.a(paramb).setLayoutParams(paramTroopLinkElement);
      return;
      zje.b.a(paramb).setImageDrawable(this.mContext.getResources().getDrawable(2130851466));
      break;
      label245:
      zje.b.a(paramb).setText(paramTroopLinkElement.url);
    }
    label259:
    zje.b.a(paramb).setVisibility(8);
    paramTroopLinkElement = (LinearLayout.LayoutParams)zje.b.a(paramb).getLayoutParams();
    paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, rpq.dip2px(this.mContext, 50.0F), paramTroopLinkElement.bottomMargin);
    zje.b.a(paramb).setLayoutParams(paramTroopLinkElement);
  }
  
  public static void j(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130838758);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(aqbn.d(localLayoutParams.width, localLayoutParams.height, rpq.dip2px(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(aqbn.a);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  private void zv(String paramString)
  {
    boolean bool1 = false;
    if ((!this.i.containsKey(paramString)) || (!this.io.containsKey(paramString))) {
      return;
    }
    boolean bool2 = ((Boolean)this.i.get(paramString)).booleanValue();
    Object localObject = (ArrayList)this.io.get(paramString);
    if (bool2)
    {
      int j = this.uh.indexOf(paramString);
      this.uh.addAll(j + 1, (Collection)localObject);
      anot.a(this.mApp, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "2", "", "");
    }
    for (;;)
    {
      localObject = this.i;
      if (!bool2) {
        bool1 = true;
      }
      ((ArrayMap)localObject).put(paramString, Boolean.valueOf(bool1));
      notifyDataSetChanged();
      return;
      this.uh.removeAll((Collection)localObject);
      anot.a(this.mApp, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "1", "", "");
    }
  }
  
  public void BG(boolean paramBoolean)
  {
    this.bro = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void W(Map<String, ArrayList<TroopLinkElement>> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    this.io = paramMap;
    this.i.clear();
    this.uh.clear();
    paramMap = this.io.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ArrayList)((Map.Entry)localObject).getValue();
      this.i.put(str, Boolean.valueOf(false));
      this.uh.add(str);
      this.uh.addAll((Collection)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkAdapter", 2, "[setElements]data size: " + this.io.size() + " header size: " + this.i.size() + " elements size: " + this.uh.size());
    }
    notifyDataSetChanged();
  }
  
  public void cpz()
  {
    this.ui.clear();
    notifyDataSetChanged();
  }
  
  public List<TroopLinkElement> dn()
  {
    return this.ui;
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LinkAdapter", 2, "[getCount]data size: " + this.io.size() + " header size: " + this.i.size() + " elements size: " + this.uh.size());
    }
    return this.uh.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.uh.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof TroopLinkElement))
    {
      localObject2 = (TroopLinkElement)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof zje.b))) {
        localObject1 = (zje.b)paramView.getTag();
      }
      for (;;)
      {
        a((zje.b)localObject1, (TroopLinkElement)localObject2);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = LayoutInflater.from(this.mContext).inflate(2131558893, null);
        localObject1 = new zje.b(paramView);
        paramView.setTag(localObject1);
      }
    }
    Object localObject1 = paramView;
    label137:
    CheckBox localCheckBox;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof zje.a))) {
        break label194;
      }
      localObject1 = (zje.a)paramView.getTag();
      localCheckBox = ((zje.a)localObject1).checkBox;
      if (((Boolean)this.i.get(localObject2)).booleanValue()) {
        break label271;
      }
    }
    label271:
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      ((zje.a)localObject1).textView.setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label194:
      paramView = LayoutInflater.from(this.mContext).inflate(2131558892, null);
      localObject1 = new zje.a();
      ((zje.a)localObject1).checkBox = ((CheckBox)paramView.findViewById(2131369742));
      ((zje.a)localObject1).textView = ((TextView)paramView.findViewById(2131379567));
      paramView.setTag(localObject1);
      paramView.setOnClickListener(new zjf(this, (zje.a)localObject1));
      break label137;
    }
  }
  
  static class a
  {
    CheckBox checkBox;
    TextView textView;
  }
  
  static class b
  {
    private CheckBox D;
    private TextView MM;
    private TextView MN;
    private View itemView;
    private RelativeLayout iz;
    private TextView titleText;
    private ImageView vk;
    
    public b(View paramView)
    {
      this.itemView = paramView.findViewById(2131369545);
      this.D = ((CheckBox)paramView.findViewById(2131370511));
      this.vk = ((ImageView)paramView.findViewById(2131370517));
      this.titleText = ((TextView)paramView.findViewById(2131379862));
      this.MM = ((TextView)paramView.findViewById(2131365614));
      this.MN = ((TextView)paramView.findViewById(2131372382));
      this.iz = ((RelativeLayout)paramView.findViewById(2131365739));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zje
 * JD-Core Version:    0.7.0.1
 */