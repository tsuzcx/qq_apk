import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class atjx
{
  private auhw jdField_a_of_type_Auhw;
  private auib jdField_a_of_type_Auib;
  private QQAppInterface app;
  private augx jdField_b_of_type_Augx;
  private auin jdField_b_of_type_Auin;
  private Context context;
  private Map<Integer, auhk.a> pp = new ConcurrentHashMap();
  private Map<Integer, auhk.e> pq = new ConcurrentHashMap();
  private Map<Integer, auhk.f> pr = new ConcurrentHashMap();
  
  public atjx(QQAppInterface paramQQAppInterface, Context paramContext, augx paramaugx)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.jdField_b_of_type_Augx = paramaugx;
  }
  
  private auhk.a a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new auhu(paramInt, paramQQAppInterface, paramContext, paramb);
    case 2: 
    case 3: 
    case 8: 
    case 9: 
      return new auip(paramInt, paramQQAppInterface, paramContext, paramb);
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      return new auhl(paramInt, paramQQAppInterface, paramContext, paramb);
    }
    return new auia(paramInt, paramQQAppInterface, paramContext, paramb);
  }
  
  private auhk.b a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return new atdx(paramContext, paramInt, this.jdField_b_of_type_Augx);
    }
    return new atdr(paramContext, paramInt, this.jdField_b_of_type_Augx);
  }
  
  private auhk.d a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return new auha(this.jdField_b_of_type_Augx);
    case 1: 
      return new auha(this.jdField_b_of_type_Augx);
    case 0: 
      return new auha(this.jdField_b_of_type_Augx);
    case 3: 
      return new auir(paramQQAppInterface, this.jdField_b_of_type_Augx);
    }
    return new auhn(paramQQAppInterface, this.jdField_b_of_type_Augx);
  }
  
  private auhk.e a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.d paramd)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = localObject;
    }
    for (;;)
    {
      paramd.a(paramQQAppInterface);
      return paramQQAppInterface;
      paramQQAppInterface = new auhh(paramQQAppInterface, paramContext, paramd);
      continue;
      paramQQAppInterface = new auhh(paramQQAppInterface, paramContext, paramd);
      continue;
      paramQQAppInterface = new auiq(paramQQAppInterface, paramContext, paramd);
      continue;
      paramQQAppInterface = new auhq(paramQQAppInterface, paramContext, paramd);
    }
  }
  
  public auhk.a a(int paramInt)
  {
    auhk.a locala1 = (auhk.a)this.pp.get(Integer.valueOf(paramInt));
    auhk.a locala2;
    if (locala1 != null) {
      locala2 = locala1;
    }
    auhk.b localb;
    do
    {
      return locala2;
      localb = a(this.context, paramInt);
      if (localb != null) {
        locala1 = a(paramInt, this.app, this.context, localb);
      }
      locala2 = locala1;
    } while (locala1 == null);
    localb.a(locala1);
    locala1.create();
    this.pp.put(Integer.valueOf(paramInt), locala1);
    return locala1;
  }
  
  public auhk.e a(int paramInt)
  {
    auhk.e locale1 = (auhk.e)this.pq.get(Integer.valueOf(paramInt));
    auhk.e locale2;
    if (locale1 != null) {
      locale2 = locale1;
    }
    auhk.d locald;
    do
    {
      return locale2;
      locald = a(this.app, paramInt);
      if (locald != null) {
        locale1 = a(paramInt, this.app, this.context, locald);
      }
      locale2 = locale1;
    } while (locale1 == null);
    locald.a(locale1);
    locale1.create();
    this.pq.put(Integer.valueOf(paramInt), locale1);
    return locale1;
  }
  
  public auhw a(auhk.g paramg)
  {
    if (this.jdField_a_of_type_Auhw == null)
    {
      this.jdField_a_of_type_Auhw = new auhw(this.app, paramg);
      this.jdField_a_of_type_Auhw.create();
    }
    return this.jdField_a_of_type_Auhw;
  }
  
  public auib a(byte[] paramArrayOfByte, auhk.g paramg)
  {
    if (this.jdField_a_of_type_Auib == null)
    {
      this.jdField_a_of_type_Auib = new auib(this.app, paramg, paramArrayOfByte);
      this.jdField_a_of_type_Auib.create();
    }
    return this.jdField_a_of_type_Auib;
  }
  
  public auin a(Context paramContext, int paramInt, auhk.g paramg)
  {
    if (this.jdField_b_of_type_Auin == null) {
      this.jdField_b_of_type_Auin = new auif(paramContext, this.app, paramg);
    }
    this.jdField_b_of_type_Auin.create();
    return this.jdField_b_of_type_Auin;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = this.pp.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.a)localIterator.next()).onAccountChanged(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_Auib != null) {
      this.jdField_a_of_type_Auib.onAccountChanged(paramQQAppInterface);
    }
    if (this.jdField_a_of_type_Auhw != null) {
      this.jdField_a_of_type_Auhw.onAccountChanged(paramQQAppInterface);
    }
    localIterator = this.pq.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.e)localIterator.next()).onAccountChanged(paramQQAppInterface);
    }
    localIterator = this.pr.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.f)localIterator.next()).onAccountChanged(paramQQAppInterface);
    }
    this.app = paramQQAppInterface;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.pp.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.a)localIterator.next()).destroy();
    }
    if (this.jdField_a_of_type_Auib != null) {
      this.jdField_a_of_type_Auib.destroy();
    }
    if (this.jdField_a_of_type_Auhw != null) {
      this.jdField_a_of_type_Auhw.destroy();
    }
    localIterator = this.pq.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.e)localIterator.next()).destroy();
    }
    localIterator = this.pr.values().iterator();
    while (localIterator.hasNext()) {
      ((auhk.f)localIterator.next()).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjx
 * JD-Core Version:    0.7.0.1
 */