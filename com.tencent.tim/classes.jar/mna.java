import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/managecolumn/CreateTopicDispatcher;", "", "()V", "createTopicListenerList", "", "Lkotlin/Function1;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "addCreateTopicListener", "listener", "notifyTopicCreate", "removeCreateTopicListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mna
{
  public static final mna a = new mna();
  private static final List<Function1<ColumnInfo, Unit>> jo = (List)new ArrayList();
  
  @JvmStatic
  public static final void a(@NotNull Function1<? super ColumnInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "listener");
    jo.add(paramFunction1);
  }
  
  @JvmStatic
  public static final void b(@NotNull Function1<? super ColumnInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "listener");
    jo.remove(paramFunction1);
  }
  
  @JvmStatic
  public static final void c(@NotNull ColumnInfo paramColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    Iterator localIterator = ((Iterable)jo).iterator();
    while (localIterator.hasNext()) {
      ((Function1)localIterator.next()).invoke(paramColumnInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mna
 * JD-Core Version:    0.7.0.1
 */