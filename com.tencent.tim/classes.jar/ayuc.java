import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ayuc
  extends aygy
{
  private static final SparseArray<ayty> em = new SparseArray();
  
  static
  {
    em.put(3000, ayty.a(98, 1, 0, ayuc.class));
    em.put(3005, ayty.a(98, 12, 0, ayuc.class));
    em.put(3006, ayty.a(98, 2, 0, ayuc.class));
    em.put(5, ayty.a(98, 5, 0, ayfw.class));
    em.put(7, ayty.a(98, 3, 0, ayfw.class));
    em.put(6, ayty.a(98, 6, 0, ayfw.class));
    em.put(11, ayty.a(98, 4, 0, aydx.class));
    em.put(12, ayty.a(98, 7, 0, EditVideoArtFilter.class));
    em.put(19, ayty.a(98, 9, 0, ayec.class));
    em.put(3001, ayty.a(98, 10, 0, aytz.class));
    em.put(3002, ayty.a(98, 8, 1, ayuf.class));
    em.put(3003, ayty.a(98, 8, 2, ayuf.class));
    em.put(3004, ayty.a(98, 11, 0, aytz.class));
  }
  
  private Set<Integer> J()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (ayfw)f(ayfw.class);
    if ((localObject != null) && (!((ayfw)localObject).isEmpty()))
    {
      if (!((ayfw)localObject).a().a().isEmpty()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (!((ayfw)localObject).a().a().isEmpty()) {
        localHashSet.add(Integer.valueOf(3));
      }
      if (!((ayfw)localObject).a().a().isEmpty()) {
        localHashSet.add(Integer.valueOf(4));
      }
    }
    localObject = (EditVideoArtFilter)f(EditVideoArtFilter.class);
    if ((localObject != null) && (((EditVideoArtFilter)localObject).KW())) {
      localHashSet.add(Integer.valueOf(5));
    }
    localObject = (aydx)f(aydx.class);
    if ((localObject != null) && (((aydx)localObject).aQu())) {
      localHashSet.add(Integer.valueOf(2));
    }
    return localHashSet;
  }
  
  private <T> T f(Class<T> paramClass)
  {
    Iterator localIterator = this.b.getParts().iterator();
    while (localIterator.hasNext())
    {
      aygy localaygy = (aygy)localIterator.next();
      if (paramClass.isInstance(localaygy)) {
        return localaygy;
      }
    }
    return null;
  }
  
  protected boolean e(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof Object[])))
    {
      long l = ((Long)((Object[])(Object[])paramMessage.obj)[0]).longValue();
      View localView = (View)((Object[])(Object[])paramMessage.obj)[1];
      QZLog.d("QzoneEditPicturePartRep", 2, "handleEditVideoMessage " + l + " " + localView);
    }
    return super.e(paramMessage);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    super.p(paramInt, paramObject);
    paramObject = (ayty)em.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3005) {
        paramObject.v(J());
      }
      paramObject.eTE();
      paramObject = (aygy)f(paramObject.k());
      if ((paramObject instanceof ayfw))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged doodle report");
        return;
      }
      if ((paramObject instanceof aydx))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged crop report");
        return;
      }
      if ((paramObject instanceof ayec))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged save report");
        return;
      }
      if ((paramObject instanceof EditVideoArtFilter))
      {
        QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged art filter report");
        return;
      }
      QZLog.d("QzoneEditPicturePartRep", 2, "editVideoStateChanged unsupported report");
      return;
    }
    QZLog.w("QzoneEditPicturePartRep", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state for reporting" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuc
 * JD-Core Version:    0.7.0.1
 */