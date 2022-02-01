import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ammh
  extends acnn
{
  public ammh(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!this.b.isAdded()) {
      QLog.e(ActiveEntitySearchFragment.TAG, 1, "handleTabSearchError, fragment is detached ..., reqKeyword=" + paramString1 + " isFirstReq=" + paramBoolean + " reqTime=" + paramString2 + " resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    while ((!TextUtils.equals(paramString2, this.b.caF)) || (!ActiveEntitySearchFragment.a(this.b.as, paramArrayOfLong)) || (!this.b.keyword.equals(paramString1))) {
      return;
    }
    this.b.GY.setVisibility(8);
    this.b.cj = false;
    this.b.loadingView.setVisibility(8);
    if ((this.b.rc == null) || (this.b.rc.isEmpty()))
    {
      this.b.listView.setVisibility(8);
      this.b.CQ.setVisibility(0);
      if (this.b.gi != null) {}
    }
    for (;;)
    {
      try
      {
        this.b.gi = BitmapFactory.decodeResource(this.b.getResources(), 2130843181);
        this.b.Du.setImageBitmap(this.b.gi);
        this.b.YG.setText(acfp.m(2131701996));
        this.b.CQ.setOnClickListener(new ammj(this));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchError code=" + paramInt + " mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.b.name);
        return;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e(ActiveEntitySearchFragment.TAG, 1, paramString2, new Object[0]);
        continue;
      }
      this.b.YI.setVisibility(0);
      this.b.YI.setOnClickListener(new ammk(this));
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ampw> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!this.b.isAdded())
    {
      QLog.e(ActiveEntitySearchFragment.TAG, 1, "handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + this.b.keyword + " reqTime=" + paramString2 + " lastReqTime=" + this.b.caF + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString2, this.b.caF))
    {
      QLog.d(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.b.keyword + " reqTime=" + paramString2 + " lastReqTime=" + this.b.caF + " isEnd1=" + paramBoolean2);
      return;
    }
    if ((!ActiveEntitySearchFragment.a(this.b.as, paramArrayOfLong)) || (!paramString1.equals(this.b.keyword)))
    {
      QLog.d(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult. masks=" + this.b.as + " reqMasks=" + paramArrayOfLong + " reqKeyword=" + paramString1 + " keyword=" + this.b.keyword + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult result=" + paramList);
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString2 = new HashSet();
    Object localObject1 = paramList.iterator();
    long l1 = -1L;
    long l2 = -1L;
    int j = 0;
    label363:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label510:
    int i;
    label572:
    long l3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ampw)((Iterator)localObject1).next();
      if (((ampw)localObject2).eX() == null) {
        break label3419;
      }
      if (!(localObject2 instanceof amov)) {
        break label3416;
      }
      localObject3 = (amov)localObject2;
      localObject4 = ((amov)localObject3).eX();
      Iterator localIterator = ((List)localObject4).iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = (ampx)localIterator.next();
        if ((localObject5 instanceof amow))
        {
          localObject5 = (amow)localObject5;
          if (ActiveEntitySearchActivity.cDf) {
            ((amow)localObject5).dDq = 1;
          }
          paramString2.add(Long.valueOf(((amow)localObject5).IW()));
        }
      }
      if (l1 != -1L) {
        break label3413;
      }
      l1 = ((amov)localObject3).ajO;
      l2 = ((amov)localObject3).ajO;
      if ((((List)localObject4).size() > 0) && (((amov)localObject3).ajO == 1001L))
      {
        anot.a(null, "dc00898", "", "", "0X800A339", "0X800A339", 1, 0, "", "", "", "");
        i = j + ((ampw)localObject2).eX().size();
        l3 = l1;
        l1 = l2;
        l2 = l3;
      }
    }
    for (;;)
    {
      l3 = l1;
      l1 = l2;
      l2 = l3;
      j = i;
      break label363;
      if ((((List)localObject4).size() > 0) && (((amov)localObject3).ajO == 1002L)) {
        anot.a(null, "dc00898", "", "", "0X800A339", "0X800A339", 2, 0, "", "", "", "");
      }
      break label572;
      this.b.FI.addAll(paramString2);
      ActiveEntitySearchFragment.a(this.b, paramString3);
      ActiveEntitySearchFragment.a(this.b, paramList1);
      if (!paramBoolean1)
      {
        paramString3 = new ArrayList();
        paramString3.addAll(paramString2);
        amxk.b("sub_result", "load_result", new String[] { this.b.keyword, amxk.N(paramString3), "", amxk.a("dynamic_tab_search.1", this.b.as) });
      }
      paramString2 = this.b.rc;
      boolean bool1;
      label892:
      boolean bool2;
      if (!paramBoolean1)
      {
        bool1 = true;
        amxg.a(paramString2, paramList, bool1, this.b.as, this.b.name, this.b.keyword);
        if (j != 0) {
          break label1347;
        }
        if ((this.b.getActivity() instanceof amkf)) {}
        switch (((amkf)this.b.getActivity()).IQ())
        {
        case 2: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.b.dCR + "   newSearchIndex:" + this.b.dCQ + " result.size():" + j);
          }
          this.b.GY.setVisibility(8);
          this.b.GZ.setVisibility(8);
          this.b.listView.setVisibility(0);
          this.b.loadingView.setVisibility(8);
          this.b.cj = false;
          this.b.fp = paramArrayOfByte;
          this.b.isEnd = paramBoolean2;
          bool2 = false;
          paramArrayOfByte = "";
          if (!TextUtils.isEmpty(paramString4))
          {
            paramString2 = paramArrayOfByte;
            bool1 = bool2;
          }
          break;
        }
      }
      int k;
      for (;;)
      {
        try
        {
          paramString3 = new JSONObject(paramString4);
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          bool2 = paramString3.optBoolean("buttonShow");
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          paramArrayOfByte = paramString3.optString("buttonText");
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          paramString3 = paramString3.optString("buttonJmpUrl");
          bool1 = bool2;
          paramString2 = paramString3;
        }
        catch (JSONException paramArrayOfByte)
        {
          label1347:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult extension parse error! " + QLog.getStackTraceString(paramArrayOfByte));
          paramString3 = "";
          paramArrayOfByte = paramString2;
          paramString2 = paramString3;
          continue;
        }
        if (!paramBoolean2) {
          break label1662;
        }
        this.b.YH.setVisibility(0);
        if ((this.b.as == null) || (this.b.as.length != 2)) {
          break label1662;
        }
        paramString3 = new ArrayList();
        paramList1 = this.b.as;
        k = paramList1.length;
        i = 0;
        if (i >= k) {
          break label1618;
        }
        paramString3.add(Long.valueOf(paramList1[i]));
        i += 1;
        continue;
        bool1 = false;
        break;
        amxk.b("sub_result", "no_result", new String[] { this.b.keyword, amxk.c(this.b.as), "", amxk.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label892;
        amxk.b("all_result", "exp_tab_empty", new String[] { this.b.keyword, amxk.c(this.b.as), "", amxk.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label892;
        if ((this.b.fp != null) || (!(this.b.getActivity() instanceof amkf))) {
          break label892;
        }
        paramString2 = (amkf)this.b.getActivity();
        switch (paramString2.IQ())
        {
        case 2: 
        default: 
          break;
        case 1: 
          amxk.b("all_result", "exp_tab_page", new String[] { this.b.keyword, amxk.N(this.b.FI), "", amxk.a("UnifySearch.Unite", paramString2.m()) });
          break;
        case 3: 
          amxk.b("sub_result", "exp_result", new String[] { paramString2.vo(), amxk.N(this.b.FI), "", amxk.a("dynamic_tab_search.1", paramString2.m()) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult extension is null");
          }
          bool1 = false;
          paramString2 = "";
          paramArrayOfByte = "";
        }
      }
      label1618:
      if ((paramString3.contains(Long.valueOf(1001L))) && (paramString3.contains(Long.valueOf(1002L)))) {
        this.b.YH.setVisibility(8);
      }
      label1662:
      int m;
      if ((!TextUtils.isEmpty(ActiveEntitySearchFragment.a(this.b))) && (ActiveEntitySearchFragment.a(this.b).size() > 0))
      {
        this.b.YF.setText(ActiveEntitySearchFragment.a(this.b));
        this.b.kn.removeAllViews();
        paramString3 = this.b.getActivity();
        if ((paramString3 == null) || (paramString3.isFinishing()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(ActiveEntitySearchFragment.TAG, 2, "activity is finished. in handleTabSearchResult.");
          return;
        }
        k = aqcx.dip2px(paramString3, 8.0F);
        m = aqcx.dip2px(paramString3, 10.0F);
        int n = aqcx.dip2px(paramString3, 2.0F);
        paramList1 = new GradientDrawable();
        paramList1.setCornerRadius(aqcx.dip2px(this.b.getActivity(), 15.0F));
        i = Color.parseColor("#E2E2E2");
        bool2 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        if (bool2) {
          i = Color.parseColor("#5a86bb");
        }
        paramList1.setStroke(1, i);
        paramString4 = ActiveEntitySearchFragment.a(this.b).iterator();
        while (paramString4.hasNext())
        {
          localObject1 = (DynamicTabSearch.SubHotWord)paramString4.next();
          localObject2 = ((DynamicTabSearch.SubHotWord)localObject1).show_word.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new TextView(paramString3);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).rightMargin = k;
            ((TextView)localObject3).setPadding(m, n, m, n);
            i = Color.parseColor("#000000");
            if (bool2) {
              i = Color.parseColor("#5a86bb");
            }
            ((TextView)localObject3).setTextColor(i);
            if (Build.VERSION.SDK_INT < 16) {
              ((TextView)localObject3).setBackgroundDrawable(paramList1.mutate());
            }
            for (;;)
            {
              ((TextView)localObject3).setText((CharSequence)localObject2);
              ((TextView)localObject3).setGravity(17);
              ((TextView)localObject3).setTextSize(1, 14.0F);
              ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
              ((TextView)localObject3).setOnClickListener(this.b);
              ((TextView)localObject3).setTag(2131368647, localObject1);
              this.b.kn.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              ((TextView)localObject3).setBackground(paramList1.mutate());
            }
          }
        }
        if (this.b.kn.getChildCount() == 0)
        {
          this.b.GX.setVisibility(8);
          if ((this.b.rc == null) || (this.b.rc.isEmpty())) {
            break label2636;
          }
          paramString2 = amkl.a(paramList, paramBoolean1, this.b.cDu);
          if ((paramBoolean1) || (l1 != ActiveEntitySearchFragment.a(this.b)) || (paramBoolean3) || (paramString2 == null) || (paramString2.size() <= 0)) {
            break label2428;
          }
          paramArrayOfByte = (ampv)this.b.rc.get(this.b.rc.size() - 1);
          paramString2.remove(0);
          k = 0;
          i = 0;
          label2222:
          if (i >= paramString2.size()) {
            break label3406;
          }
          if (!((ampv)paramString2.get(i) instanceof ampf)) {
            break label2415;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayOfByte instanceof ampx))
        {
          paramArrayOfByte = (ampx)paramArrayOfByte;
          k = paramArrayOfByte.pE();
          amxl.a(paramArrayOfByte, k + i, k - 1);
        }
        for (;;)
        {
          m = 0;
          for (;;)
          {
            if (m < i)
            {
              paramArrayOfByte = (ampv)paramString2.get(m);
              if ((paramArrayOfByte instanceof ampx)) {
                amxl.a((ampx)paramArrayOfByte, k + i, k + m);
              }
              m += 1;
              continue;
              if (((this.b.rc == null) || (this.b.rc.isEmpty())) && ((paramList == null) || (paramList.isEmpty()))) {
                break;
              }
              this.b.GX.setVisibility(0);
              break;
              this.b.GX.setVisibility(8);
              break;
              label2415:
              k = i;
              i += 1;
              break label2222;
            }
          }
          label2428:
          this.b.mc(paramString2);
          this.b.rc.addAll(paramString2);
          this.b.a.cS(this.b.rc);
          ActiveEntitySearchFragment.a(this.b, l2);
          if (!this.b.isEnd)
          {
            paramString2 = this.b;
            paramString2.dCR += j;
            paramString2 = this.b;
            paramString2.dCQ += 1;
            if (this.b.dCR > 10)
            {
              this.b.dCQ = 0;
              this.b.dCR = 0;
            }
          }
          else
          {
            label2546:
            if (!paramBoolean2) {
              break label3317;
            }
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult isEnd = true mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.b.name + "  fragmentMask=" + Arrays.toString(this.b.as));
            }
          }
          for (;;)
          {
            ActiveEntitySearchActivity.cDe = true;
            return;
            label2636:
            if ((paramList == null) || (paramList.isEmpty()))
            {
              this.b.CQ.setVisibility(0);
              paramString3 = (achg)this.b.d.getManager(159);
              if ((!bool1) && (paramString3.bIf)) {
                if (this.b.c == null)
                {
                  this.b.c = new yvj(this.b.d, this.b.getActivity(), this.b.S, null);
                  paramString2 = this.b.c.a();
                  paramArrayOfByte = new TextView(this.b.getActivity());
                  paramArrayOfByte.setGravity(17);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(105.0F, this.b.getResources())));
                  paramArrayOfByte.setTextColor(this.b.getResources().getColor(2131167383));
                  paramArrayOfByte.setTextSize(1, 17.0F);
                  paramArrayOfByte.setText(acfp.m(2131702000));
                  paramArrayOfByte.setBackgroundResource(2130838901);
                  paramString2.addHeaderView(paramArrayOfByte);
                  paramArrayOfByte = new TextView(this.b.getActivity());
                  paramArrayOfByte.setTextColor(this.b.getResources().getColor(2131167383));
                  paramArrayOfByte.setTextSize(1, 14.0F);
                  paramArrayOfByte.setGravity(16);
                  paramArrayOfByte.setPadding(wja.dp2px(15.0F, this.b.getResources()), 0, 0, 0);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(40.0F, this.b.getResources())));
                  paramArrayOfByte.setText(acfp.m(2131701998));
                  paramArrayOfByte.setBackgroundResource(2130838901);
                  paramString2.addHeaderView(paramArrayOfByte);
                  this.b.S.setVisibility(0);
                  this.b.YH.setVisibility(8);
                }
              }
            }
            for (;;)
            {
              for (;;)
              {
                label2973:
                label2984:
                paramString2 = amkl.a(paramList, paramBoolean1, this.b.cDu);
                this.b.mc(paramString2);
                this.b.rc = paramString2;
                this.b.a.cS(this.b.rc);
                break;
                this.b.c.refresh();
                break label2973;
                this.b.S.setVisibility(8);
                if (this.b.gi == null) {}
                try
                {
                  if (this.b.isAdded())
                  {
                    this.b.gi = BitmapFactory.decodeResource(this.b.getResources(), 2130843181);
                    this.b.Du.setImageBitmap(this.b.gi);
                  }
                  this.b.YG.setText(acfp.m(2131701991));
                  if (bool1)
                  {
                    this.b.hd.setVisibility(0);
                    this.b.hd.setOnClickListener(new ammi(this, paramString2));
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break label2984;
                    }
                    this.b.hd.setText(paramArrayOfByte);
                    this.b.YG.setPadding(0, aqcx.dip2px(this.b.YG.getContext(), 15.0F), 0, 0);
                  }
                }
                catch (OutOfMemoryError paramString3)
                {
                  for (;;)
                  {
                    QLog.e(ActiveEntitySearchFragment.TAG, 1, paramString3, new Object[0]);
                  }
                  this.b.hd.setVisibility(8);
                }
              }
              break label2984;
              this.b.CQ.setVisibility(8);
            }
            if (this.b.dCQ >= 3)
            {
              this.b.isEnd = true;
              break label2546;
            }
            this.b.PO(this.b.keyword);
            break label2546;
            label3317:
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.TAG, 2, "handleTabSearchResult isEnd = false mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.b.name + "  fragmentMask=" + Arrays.toString(this.b.as));
            }
          }
          k = 0;
        }
        label3406:
        i = k;
      }
      label3413:
      break label510;
      label3416:
      break label572;
      label3419:
      l3 = l2;
      i = j;
      l2 = l1;
      l1 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammh
 * JD-Core Version:    0.7.0.1
 */