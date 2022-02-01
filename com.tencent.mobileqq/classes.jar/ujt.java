import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/SuperMaskStepUtil;", "", "()V", "dealStepResult", "", "result", "step", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "doSuperMaskStep", "tag", "", "steps", "", "(Ljava/lang/String;[Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;)Z", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ujt
{
  public static final ujt a = new ujt();
  
  public final boolean a(@NotNull String paramString, @NotNull ujc... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "steps");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ujc localujc = paramVarArgs[i];
      localujc.a(paramString);
      if (!localujc.a()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean a(boolean paramBoolean, @NotNull ujc paramujc)
  {
    Intrinsics.checkParameterIsNotNull(paramujc, "step");
    StringBuilder localStringBuilder = new StringBuilder().append(paramujc.a() + " : ").append(paramujc.getClass().getSimpleName() + " : ");
    if (paramujc.b() != null) {
      localStringBuilder.append(paramujc.b() + " : ");
    }
    if (!paramBoolean) {
      localStringBuilder.append("check fail");
    }
    for (;;)
    {
      ukq.a("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return paramBoolean;
      localStringBuilder.append("check success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujt
 * JD-Core Version:    0.7.0.1
 */