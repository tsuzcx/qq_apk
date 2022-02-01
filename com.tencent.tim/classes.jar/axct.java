import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class axct
  implements axzv<axcb>
{
  axct(axco paramaxco) {}
  
  public void a(@Nullable axcb paramaxcb)
  {
    if (paramaxcb == null) {
      return;
    }
    axby localaxby;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = axco.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localaxby = (axby)localIterator.next();
      if (!localaxby.id.equals(paramaxcb.b.id)) {
        break;
      }
      if (localaxby.state != paramaxcb.downloadState)
      {
        localaxby.state = paramaxcb.downloadState;
        axco.a(this.a).notifyItemChanged(axco.a(this.a).indexOf(localaxby) + 1);
      }
    } while ((localaxby.state != 2) || (!localaxby.id.equals(axco.a(this.a))));
    axco.a(this.a).e(localaxby);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axct
 * JD-Core Version:    0.7.0.1
 */