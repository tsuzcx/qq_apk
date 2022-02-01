import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class juh
{
  String Um;
  protected jtw a;
  protected AdapterView.c d = new juj(this);
  protected ArrayList<jzs.a> jt = new ArrayList();
  protected Context mContext;
  String puin;
  protected View.OnClickListener x = new jui(this);
  
  public juh(Context paramContext, ArrayList<jzs.a> paramArrayList, jtw paramjtw, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.jt = paramArrayList;
    this.a = paramjtw;
    this.puin = paramString1;
    this.Um = paramString2;
  }
  
  public static ArrayList<jzs.a> a(jzs paramjzs, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramjzs != null) && (paramjzs.fR != null))
    {
      Iterator localIterator = paramjzs.fR.iterator();
      while (localIterator.hasNext())
      {
        jzs.a locala = (jzs.a)localIterator.next();
        if ((locala.aGG == 0) || ((locala.aGG == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramjzs.type)
          {
          default: 
            break;
          case 2: 
            if (locala.aGH != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(locala.pic_url)) || (TextUtils.isEmpty(locala.content))) {
              break;
            }
            localArrayList.add(locala);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(locala.pic_url))
        {
          localArrayList.add(locala);
          continue;
          if (locala.aGH == 23)
          {
            if ((!TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(locala.title)) && (!TextUtils.isEmpty(locala.content))) {
              localArrayList.add(locala);
            }
          }
          else if ((!TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(locala.title))) {
            localArrayList.add(locala);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void c(jzs.a parama)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (acja)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((acja)localObject2).a(this.puin);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.mContext != null) && ((this.mContext instanceof AccountDetailActivity))) {}
        for (int j = kbp.a((QQAppInterface)localObject1, this.puin, null);; j = 1)
        {
          if ((parama.type == 3) && (parama.aGH == 23))
          {
            parama = parama.content;
            localObject1 = new jts();
            ((jts)localObject1).lo(parama);
            localObject1 = ((jts)localObject1).a.vid;
            localObject2 = this.puin;
            if (i != 0)
            {
              parama = "02";
              kbp.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, parama, String.valueOf(j), false);
            }
          }
          while (parama.type != 1) {
            for (;;)
            {
              return;
              parama = "01";
            }
          }
          parama = Uri.parse(parama.url);
          try
          {
            parama = parama.getQueryParameter("article_id");
            if (TextUtils.isEmpty(parama))
            {
              parama = "";
              localObject2 = this.puin;
              if (i != 0)
              {
                localObject1 = "02";
                kbp.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", parama, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              parama.printStackTrace();
              parama = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean q(ArrayList<jzs.a> paramArrayList)
  {
    if (paramArrayList.size() != this.jt.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label49;
      }
      if (paramArrayList.get(i) != this.jt.get(i)) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juh
 * JD-Core Version:    0.7.0.1
 */