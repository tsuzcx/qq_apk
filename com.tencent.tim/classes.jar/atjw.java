import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class atjw
{
  private atjy jdField_a_of_type_Atjy;
  private atjz jdField_a_of_type_Atjz;
  private atkb jdField_a_of_type_Atkb;
  private atkc jdField_a_of_type_Atkc;
  private atkd jdField_a_of_type_Atkd;
  private atkf jdField_a_of_type_Atkf;
  private atkh jdField_a_of_type_Atkh;
  private atkj jdField_a_of_type_Atkj;
  private atkl jdField_a_of_type_Atkl;
  private atkm jdField_a_of_type_Atkm;
  private atko jdField_a_of_type_Atko;
  private QQAppInterface app;
  private Context context;
  private Map<Integer, atjv> po = new ConcurrentHashMap();
  
  public atjw(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
  }
  
  public int a(atiu paramatiu)
  {
    return paramatiu.getCloudFileType();
  }
  
  public atjv a(int paramInt1, BaseAdapter paramBaseAdapter, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      paramBaseAdapter = localObject;
    }
    for (;;)
    {
      if ((paramBaseAdapter != null) && (!this.po.containsKey(Integer.valueOf(paramInt1)))) {
        this.po.put(Integer.valueOf(paramInt1), paramBaseAdapter);
      }
      return paramBaseAdapter;
      if (this.jdField_a_of_type_Atjz == null) {
        this.jdField_a_of_type_Atjz = new atjz(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atjz;
      continue;
      if (this.jdField_a_of_type_Atkf == null) {
        this.jdField_a_of_type_Atkf = new atkf(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkf;
      continue;
      if (this.jdField_a_of_type_Atkl == null) {
        this.jdField_a_of_type_Atkl = new atkl(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkl;
      continue;
      if (this.jdField_a_of_type_Atkm == null) {
        this.jdField_a_of_type_Atkm = new atkm(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkm;
      continue;
      if (this.jdField_a_of_type_Atjy == null) {
        this.jdField_a_of_type_Atjy = new atjy(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atjy;
      continue;
      if (this.jdField_a_of_type_Atkd == null) {
        this.jdField_a_of_type_Atkd = new atkd(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkd;
      continue;
      if (this.jdField_a_of_type_Atko == null) {
        this.jdField_a_of_type_Atko = new atko(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atko;
      continue;
      if (this.jdField_a_of_type_Atkf == null) {
        this.jdField_a_of_type_Atkf = new atkf(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkf;
      continue;
      if (this.jdField_a_of_type_Atkj == null) {
        this.jdField_a_of_type_Atkj = new atkj(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkj;
      continue;
      if (this.jdField_a_of_type_Atkc == null) {
        this.jdField_a_of_type_Atkc = new atkc(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkc;
      continue;
      if (this.jdField_a_of_type_Atkh == null) {
        this.jdField_a_of_type_Atkh = new atkh(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkh;
      continue;
      if (this.jdField_a_of_type_Atkb == null) {
        this.jdField_a_of_type_Atkb = new atkb(this.app, this.context, paramBaseAdapter, paramInt2);
      }
      paramBaseAdapter = this.jdField_a_of_type_Atkb;
    }
  }
  
  public atjv a(atiu paramatiu, BaseAdapter paramBaseAdapter, int paramInt)
  {
    paramInt = paramatiu.getCloudFileType();
    return (atjv)this.po.get(Integer.valueOf(paramInt));
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.po.values().iterator();
    while (localIterator.hasNext()) {
      ((atjv)localIterator.next()).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjw
 * JD-Core Version:    0.7.0.1
 */