import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ActionItem;", "", "name", "", "action", "", "webHandle", "", "(Ljava/lang/String;IZ)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class oaq
{
  @JvmField
  public int action;
  @JvmField
  public boolean avZ;
  @JvmField
  @NotNull
  public String name;
  
  public oaq(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    this.name = paramString;
    this.action = paramInt;
    this.avZ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oaq
 * JD-Core Version:    0.7.0.1
 */