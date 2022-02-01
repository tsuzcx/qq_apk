import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aklh
{
  public static final aklh a = new aklh();
  private static final Map<Integer, akky> mm = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new aklg()), TuplesKt.to(Integer.valueOf(-1), new akli()), TuplesKt.to(Integer.valueOf(4), new akle()) });
  
  @NotNull
  public final akky a(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    if (paramaklc.csH) {
      paramaklc = (akky)new aklg();
    }
    akky localakky;
    do
    {
      return paramaklc;
      localakky = (akky)mm.get(Integer.valueOf(paramaklc.dnv));
      paramaklc = localakky;
    } while (localakky != null);
    return (akky)new aklf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklh
 * JD-Core Version:    0.7.0.1
 */