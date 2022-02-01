import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.BusinessSearchEntryModel.2;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amji
  extends amjh<View>
{
  private boolean cCW;
  private LinearLayout km;
  private QQAppInterface mApp;
  private Context mContext;
  private View mRootView;
  
  public amji(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.cCW = paramBoolean;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label97;
      }
    }
    label97:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.mRootView = LayoutInflater.from(paramContext).inflate(2131563293, null);
      this.km = ((LinearLayout)this.mRootView.findViewById(2131370687));
      return this.mRootView;
    }
  }
  
  public void a(amrb paramamrb)
  {
    b(paramamrb);
  }
  
  public void b(amrb paramamrb)
  {
    Object localObject1 = this.mApp.getCurrentUin();
    paramamrb = (amof)paramamrb;
    if (paramamrb == null) {}
    for (;;)
    {
      return;
      List localList = paramamrb.entries;
      if ((localList != null) && (localList.size() != 0))
      {
        label78:
        int i;
        label80:
        amof.a locala;
        View localView1;
        View localView2;
        Object localObject2;
        if (localList.size() <= 6)
        {
          this.km.setVisibility(8);
          if (localList.size() != 10) {
            break label424;
          }
          paramamrb = ga();
          i = 0;
          if (i >= localList.size()) {
            break label462;
          }
          locala = (amof.a)localList.get(i);
          localView1 = this.mRootView.findViewById(((Integer)paramamrb.get(i)).intValue());
          localView2 = localView1.findViewById(2131377002);
          TextView localTextView = (TextView)localView1.findViewById(2131365927);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365926);
          localView1.setVisibility(0);
          localObject2 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject2).setColor(this.mContext.getResources().getColor(2131167624));
          label209:
          if (!TextUtils.isEmpty(locala.iconUrl))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = wja.dp2px(28.0F, this.mContext.getResources());
            localURLDrawableOptions.mRequestWidth = wja.dp2px(28.0F, this.mContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localObject2 = URLDrawable.getDrawable(locala.iconUrl, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject2);
            }
          }
          localTextView.setText(locala.title);
          int j = aqmj.t(locala.dDd, (String)localObject1);
          boolean bool = aqmj.S(locala.dDd, (String)localObject1);
          if ((locala.dDb != 1) || ((locala.dDc <= j) && ((locala.dDc != j) || (bool)))) {
            break label452;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          aqmj.O(locala.dDd, locala.dDc, (String)localObject1);
          localView1.setOnClickListener(new amjj(this, localView1, locala, localView2, (String)localObject1, localList));
          i += 1;
          break label80;
          this.km.setVisibility(0);
          break;
          label424:
          paramamrb = fZ();
          break label78;
          label432:
          ((ColorDrawable)localObject2).setColor(this.mContext.getResources().getColor(2131167623));
          break label209;
          label452:
          localView2.setVisibility(8);
        }
        label462:
        if (localList.size() < 6)
        {
          i = localList.size();
          while (i < 6)
          {
            this.mRootView.findViewById(((Integer)paramamrb.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (localList.size() == 6)
        {
          this.mRootView.findViewById(2131365937).setVisibility(8);
          this.mRootView.findViewById(2131365938).setVisibility(8);
          this.mRootView.findViewById(2131365939).setVisibility(8);
          this.mRootView.findViewById(2131365929).setVisibility(8);
          this.mRootView.findViewById(2131365930).setVisibility(8);
          this.mRootView.findViewById(2131365931).setVisibility(8);
          paramamrb = new StringBuilder("");
          i = 0;
          label628:
          if (i >= localList.size()) {
            break label750;
          }
          if (i != localList.size() - 1) {
            break label722;
          }
          paramamrb.append(((amof.a)localList.get(i)).title);
        }
        for (;;)
        {
          i += 1;
          break label628;
          if (localList.size() != 10) {
            break;
          }
          this.mRootView.findViewById(2131365936).setVisibility(8);
          this.mRootView.findViewById(2131365931).setVisibility(8);
          break;
          label722:
          paramamrb.append(((amof.a)localList.get(i)).title).append("::");
        }
        label750:
        localObject1 = (Boolean)SearchEntryFragment.mW.get(Integer.valueOf(3));
        if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
        {
          amxk.b("home_page", "exp_entry", new String[] { paramamrb.toString(), "", String.valueOf(this.bms) });
          amub.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(amub.eZ(this.bms)).ver4(paramamrb.toString()).ver7("{experiment_id:" + amub.cce + "}"));
          SearchEntryFragment.mW.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.jf(this.bms);
          paramamrb = localList.iterator();
          while (paramamrb.hasNext())
          {
            localObject1 = (amof.a)paramamrb.next();
            if (localObject1 != null) {
              amub.a(this.mApp, 0, i, "0X8009D1B", 0, 0, ((amof.a)localObject1).title, null);
            }
          }
        }
      }
    }
  }
  
  public List<Integer> fZ()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365928));
    localArrayList.add(Integer.valueOf(2131365932));
    localArrayList.add(Integer.valueOf(2131365933));
    localArrayList.add(Integer.valueOf(2131365934));
    localArrayList.add(Integer.valueOf(2131365935));
    localArrayList.add(Integer.valueOf(2131365936));
    localArrayList.add(Integer.valueOf(2131365937));
    localArrayList.add(Integer.valueOf(2131365938));
    localArrayList.add(Integer.valueOf(2131365939));
    localArrayList.add(Integer.valueOf(2131365929));
    localArrayList.add(Integer.valueOf(2131365930));
    localArrayList.add(Integer.valueOf(2131365931));
    return localArrayList;
  }
  
  public List<Integer> ga()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365928));
    localArrayList.add(Integer.valueOf(2131365932));
    localArrayList.add(Integer.valueOf(2131365933));
    localArrayList.add(Integer.valueOf(2131365934));
    localArrayList.add(Integer.valueOf(2131365935));
    localArrayList.add(Integer.valueOf(2131365937));
    localArrayList.add(Integer.valueOf(2131365938));
    localArrayList.add(Integer.valueOf(2131365939));
    localArrayList.add(Integer.valueOf(2131365929));
    localArrayList.add(Integer.valueOf(2131365930));
    return localArrayList;
  }
  
  public void initData()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new amof(this.mApp, 3, this.bms, this.cCW)), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amji
 * JD-Core Version:    0.7.0.1
 */