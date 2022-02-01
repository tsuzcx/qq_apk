package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface MatchResult
{
  @NotNull
  public abstract Destructured getDestructured();
  
  @NotNull
  public abstract List<String> getGroupValues();
  
  @NotNull
  public abstract MatchGroupCollection getGroups();
  
  @NotNull
  public abstract IntRange getRange();
  
  @NotNull
  public abstract String getValue();
  
  @Nullable
  public abstract MatchResult next();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls
  {
    @NotNull
    public static MatchResult.Destructured getDestructured(MatchResult paramMatchResult)
    {
      return new MatchResult.Destructured(paramMatchResult);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Destructured
  {
    @NotNull
    private final MatchResult match;
    
    public Destructured(@NotNull MatchResult paramMatchResult)
    {
      this.match = paramMatchResult;
    }
    
    @InlineOnly
    private final String component1()
    {
      return (String)getMatch().getGroupValues().get(1);
    }
    
    @InlineOnly
    private final String component10()
    {
      return (String)getMatch().getGroupValues().get(10);
    }
    
    @InlineOnly
    private final String component2()
    {
      return (String)getMatch().getGroupValues().get(2);
    }
    
    @InlineOnly
    private final String component3()
    {
      return (String)getMatch().getGroupValues().get(3);
    }
    
    @InlineOnly
    private final String component4()
    {
      return (String)getMatch().getGroupValues().get(4);
    }
    
    @InlineOnly
    private final String component5()
    {
      return (String)getMatch().getGroupValues().get(5);
    }
    
    @InlineOnly
    private final String component6()
    {
      return (String)getMatch().getGroupValues().get(6);
    }
    
    @InlineOnly
    private final String component7()
    {
      return (String)getMatch().getGroupValues().get(7);
    }
    
    @InlineOnly
    private final String component8()
    {
      return (String)getMatch().getGroupValues().get(8);
    }
    
    @InlineOnly
    private final String component9()
    {
      return (String)getMatch().getGroupValues().get(9);
    }
    
    @NotNull
    public final MatchResult getMatch()
    {
      return this.match;
    }
    
    @NotNull
    public final List<String> toList()
    {
      return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.MatchResult
 * JD-Core Version:    0.7.0.1
 */