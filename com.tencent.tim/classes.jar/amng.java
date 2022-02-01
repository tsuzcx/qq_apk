import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.1;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class amng
  extends acnn
{
  public amng(PublicAcntSearchFragment paramPublicAcntSearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
    }
    this.this$0.cj = false;
    this.this$0.handler.sendEmptyMessage(3);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ampw> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult， keyword=" + this.this$0.keyword + ", isFirstReq=" + paramBoolean1 + " ,cookie = " + paramArrayOfByte + ",result=" + paramList.size());
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.1(this, paramBoolean2));
    if (!TextUtils.equals(paramString2, this.this$0.caF))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.this$0.keyword + " reqTime=" + paramString2 + " lastReqTime=" + this.this$0.caF + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString1, this.this$0.keyword))
    {
      QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. masks=" + paramArrayOfLong[0] + " reqKeyword=" + paramString1 + " keyword=" + this.this$0.keyword + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult result is null");
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString1 = paramList.iterator();
    int i = 0;
    long l2 = -1L;
    long l1 = -1L;
    label307:
    int j;
    if (paramString1.hasNext())
    {
      paramString2 = (ampw)paramString1.next();
      if (paramString2.eX() == null) {
        break label1056;
      }
      long l3 = l1;
      if ((paramString2 instanceof amov))
      {
        paramString3 = (amov)paramString2;
        l3 = l1;
        if (l1 == -1L) {
          l3 = paramString3.ajO;
        }
        l2 = paramString3.ajO;
      }
      j = paramString2.eX().size();
      l1 = l3;
      i += j;
    }
    label1049:
    label1056:
    for (;;)
    {
      break label307;
      if (!paramBoolean1) {
        amxk.b("sub_result", "load_result", new String[] { this.this$0.keyword, amxk.c(paramArrayOfLong), "", amxk.a("dynamic_tab_search.1", paramArrayOfLong) });
      }
      if (i == 0)
      {
        amxk.b("sub_result", "no_result", new String[] { this.this$0.keyword, amxk.c(paramArrayOfLong), "", amxk.a("dynamic_tab_search.1", paramArrayOfLong) });
        this.this$0.isEnd = paramBoolean2;
        this.this$0.cj = false;
        this.this$0.cookie = paramArrayOfByte;
        if ((this.this$0.rc == null) || (this.this$0.rc.isEmpty())) {
          break label949;
        }
        paramString1 = amkl.e(paramList, paramBoolean1);
        if ((paramBoolean1) || (l1 != PublicAcntSearchFragment.a(this.this$0)) || (paramString1 == null) || (paramString1.size() <= 0) || (paramBoolean3)) {
          break label865;
        }
        paramString2 = (ampv)this.this$0.rc.get(this.this$0.rc.size() - 1);
        if ((!(this.this$0.rc.get(this.this$0.rc.size() - 1) instanceof amqy)) || (!(paramString1.get(0) instanceof ampf))) {
          paramString1.remove(0);
        }
        j = 0;
        i = 0;
        label685:
        if (i >= paramString1.size()) {
          break label1049;
        }
        if (!((ampv)paramString1.get(i) instanceof ampf)) {
          break label852;
        }
      }
      for (;;)
      {
        if ((paramString2 instanceof ampx))
        {
          paramString2 = (ampx)paramString2;
          j = paramString2.pE();
          amxl.a(paramString2, j + i, j - 1);
        }
        for (;;)
        {
          int k = 0;
          for (;;)
          {
            if (k < i)
            {
              paramString2 = (ampv)paramString1.get(k);
              if ((paramString2 instanceof ampx)) {
                amxl.a((ampx)paramString2, j + i, j + k);
              }
              k += 1;
              continue;
              if (!paramBoolean1) {
                break;
              }
              amxk.b("sub_result", "exp_result", new String[] { this.this$0.keyword, amxk.c(paramArrayOfLong), "", amxk.a("dynamic_tab_search.1", paramArrayOfLong) });
              break;
              label852:
              j = i;
              i += 1;
              break label685;
            }
          }
          label865:
          this.this$0.rc.addAll(paramString1);
          for (;;)
          {
            i = 0;
            while (i < this.this$0.rc.size())
            {
              if ((this.this$0.rc.get(i) instanceof amqg)) {
                ((amqg)this.this$0.rc.get(i)).dDv = 0;
              }
              i += 1;
            }
            label949:
            paramString1 = amkl.e(paramList, paramBoolean1);
            this.this$0.rc = paramString1;
          }
          this.this$0.a.cS(this.this$0.rc);
          PublicAcntSearchFragment.a(this.this$0, l2);
          if ((this.this$0.rc.size() != 0) || (TextUtils.isEmpty(this.this$0.keyword)) || (!paramBoolean2)) {
            break;
          }
          ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.2.2(this));
          return;
          j = 0;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amng
 * JD-Core Version:    0.7.0.1
 */