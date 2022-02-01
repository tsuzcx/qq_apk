package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"", ""}, d2={"indices", "Lkotlin/ranges/IntRange;", "T", "", "getIndices", "([Ljava/lang/Object;)Lkotlin/ranges/IntRange;", "", "([Z)Lkotlin/ranges/IntRange;", "", "([B)Lkotlin/ranges/IntRange;", "", "([C)Lkotlin/ranges/IntRange;", "", "([D)Lkotlin/ranges/IntRange;", "", "([F)Lkotlin/ranges/IntRange;", "", "([I)Lkotlin/ranges/IntRange;", "", "([J)Lkotlin/ranges/IntRange;", "", "([S)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "([Ljava/lang/Object;)I", "([Z)I", "([B)I", "([C)I", "([D)I", "([F)I", "([I)I", "([J)I", "([S)I", "all", "", "predicate", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "", "", "", "", "", "", "any", "([Ljava/lang/Object;)Z", "asIterable", "", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "asSequence", "Lkotlin/sequences/Sequence;", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateBy", "keySelector", "valueTransform", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateByTo", "M", "", "destination", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "average", "averageOfByte", "([Ljava/lang/Byte;)D", "averageOfDouble", "([Ljava/lang/Double;)D", "averageOfFloat", "([Ljava/lang/Float;)D", "averageOfInt", "([Ljava/lang/Integer;)D", "averageOfLong", "([Ljava/lang/Long;)D", "averageOfShort", "([Ljava/lang/Short;)D", "component1", "([Ljava/lang/Object;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "count", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "distinct", "", "([Ljava/lang/Object;)Ljava/util/List;", "distinctBy", "selector", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "drop", "n", "([Ljava/lang/Object;I)Ljava/util/List;", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([ZI)Ljava/lang/Boolean;", "([BI)Ljava/lang/Byte;", "([CI)Ljava/lang/Character;", "([DI)Ljava/lang/Double;", "([FI)Ljava/lang/Float;", "([II)Ljava/lang/Integer;", "([JI)Ljava/lang/Long;", "([SI)Ljava/lang/Short;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexedTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "R", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Short;", "findLast", "first", "firstOrNull", "([Z)Ljava/lang/Boolean;", "([B)Ljava/lang/Byte;", "([C)Ljava/lang/Character;", "([D)Ljava/lang/Double;", "([F)Ljava/lang/Float;", "([I)Ljava/lang/Integer;", "([J)Ljava/lang/Long;", "([S)Ljava/lang/Short;", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/collections/Grouping;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/Set;", "isEmpty", "isNotEmpty", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ZLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([CLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([DLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([FLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ILjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([JLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([SLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "([Ljava/lang/Comparable;)Ljava/lang/Comparable;", "([Ljava/lang/Double;)Ljava/lang/Double;", "([Ljava/lang/Float;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "([ZLjava/util/Comparator;)Ljava/lang/Boolean;", "([BLjava/util/Comparator;)Ljava/lang/Byte;", "([CLjava/util/Comparator;)Ljava/lang/Character;", "([DLjava/util/Comparator;)Ljava/lang/Double;", "([FLjava/util/Comparator;)Ljava/lang/Float;", "([ILjava/util/Comparator;)Ljava/lang/Integer;", "([JLjava/util/Comparator;)Ljava/lang/Long;", "([SLjava/util/Comparator;)Ljava/lang/Short;", "min", "minBy", "minWith", "none", "partition", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "random", "Lkotlin/random/Random;", "([Ljava/lang/Object;Lkotlin/random/Random;)Ljava/lang/Object;", "randomOrNull", "([ZLkotlin/random/Random;)Ljava/lang/Boolean;", "([BLkotlin/random/Random;)Ljava/lang/Byte;", "([CLkotlin/random/Random;)Ljava/lang/Character;", "([DLkotlin/random/Random;)Ljava/lang/Double;", "([FLkotlin/random/Random;)Ljava/lang/Float;", "([ILkotlin/random/Random;)Ljava/lang/Integer;", "([JLkotlin/random/Random;)Ljava/lang/Long;", "([SLkotlin/random/Random;)Ljava/lang/Short;", "reduce", "S", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceOrNull", "([ZLkotlin/jvm/functions/Function2;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function2;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function2;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function2;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function2;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function2;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function2;)Ljava/lang/Short;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "requireNoNulls", "([Ljava/lang/Object;)[Ljava/lang/Object;", "reverse", "([Ljava/lang/Object;)V", "reversed", "reversedArray", "scan", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "single", "singleOrNull", "slice", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)Ljava/util/List;", "sliceArray", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)[Ljava/lang/Object;", "sortBy", "sortByDescending", "sortDescending", "([Ljava/lang/Comparable;)V", "sorted", "([Ljava/lang/Comparable;)Ljava/util/List;", "sortedArray", "([Ljava/lang/Comparable;)[Ljava/lang/Comparable;", "sortedArrayDescending", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "subtract", "sum", "sumOfByte", "([Ljava/lang/Byte;)I", "sumOfDouble", "sumOfFloat", "([Ljava/lang/Float;)F", "sumOfInt", "([Ljava/lang/Integer;)I", "sumOfLong", "([Ljava/lang/Long;)J", "sumOfShort", "([Ljava/lang/Short;)I", "sumBy", "sumByDouble", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)D", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "([Ljava/lang/Boolean;)[Z", "toByteArray", "([Ljava/lang/Byte;)[B", "toCharArray", "([Ljava/lang/Character;)[C", "toCollection", "([ZLjava/util/Collection;)Ljava/util/Collection;", "([BLjava/util/Collection;)Ljava/util/Collection;", "([CLjava/util/Collection;)Ljava/util/Collection;", "([DLjava/util/Collection;)Ljava/util/Collection;", "([FLjava/util/Collection;)Ljava/util/Collection;", "([ILjava/util/Collection;)Ljava/util/Collection;", "([JLjava/util/Collection;)Ljava/util/Collection;", "([SLjava/util/Collection;)Ljava/util/Collection;", "toDoubleArray", "([Ljava/lang/Double;)[D", "toFloatArray", "([Ljava/lang/Float;)[F", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "toIntArray", "([Ljava/lang/Integer;)[I", "toList", "toLongArray", "([Ljava/lang/Long;)[J", "toMutableList", "toMutableSet", "", "([Ljava/lang/Object;)Ljava/util/Set;", "toSet", "toShortArray", "([Ljava/lang/Short;)[S", "union", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "a", "b", "([Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Ljava/lang/Object;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Z[Ljava/lang/Object;)Ljava/util/List;", "([Z[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([B[Ljava/lang/Object;)Ljava/util/List;", "([B[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([C[Ljava/lang/Object;)Ljava/util/List;", "([C[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([D[Ljava/lang/Object;)Ljava/util/List;", "([D[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([F[Ljava/lang/Object;)Ljava/util/List;", "([F[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([I[Ljava/lang/Object;)Ljava/util/List;", "([I[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([J[Ljava/lang/Object;)Ljava/util/List;", "([J[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([S[Ljava/lang/Object;)Ljava/util/List;", "([S[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/ArraysKt")
public class ArraysKt___ArraysKt
  extends ArraysKt___ArraysJvmKt
{
  public static final boolean all(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final <T> boolean all(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean all(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean any(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$any");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$any");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$any");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$any");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$any");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$any");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final <T> boolean any(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$any");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final <T> boolean any(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$any");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static final boolean any(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$any");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @NotNull
  public static final Iterable<Byte> asIterable(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asIterable");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.2(paramArrayOfByte);
  }
  
  @NotNull
  public static final Iterable<Character> asIterable(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$asIterable");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.9(paramArrayOfChar);
  }
  
  @NotNull
  public static final Iterable<Double> asIterable(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$asIterable");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.7(paramArrayOfDouble);
  }
  
  @NotNull
  public static final Iterable<Float> asIterable(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$asIterable");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.6(paramArrayOfFloat);
  }
  
  @NotNull
  public static final Iterable<Integer> asIterable(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asIterable");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.4(paramArrayOfInt);
  }
  
  @NotNull
  public static final Iterable<Long> asIterable(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asIterable");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.5(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> Iterable<T> asIterable(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$asIterable");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.1(paramArrayOfT);
  }
  
  @NotNull
  public static final Iterable<Short> asIterable(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asIterable");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.3(paramArrayOfShort);
  }
  
  @NotNull
  public static final Iterable<Boolean> asIterable(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$asIterable");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Iterable)CollectionsKt.emptyList();
    }
    return (Iterable)new ArraysKt___ArraysKt.asIterable..inlined.Iterable.8(paramArrayOfBoolean);
  }
  
  @NotNull
  public static final Sequence<Byte> asSequence(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asSequence");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.2(paramArrayOfByte);
  }
  
  @NotNull
  public static final Sequence<Character> asSequence(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$asSequence");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.9(paramArrayOfChar);
  }
  
  @NotNull
  public static final Sequence<Double> asSequence(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$asSequence");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.7(paramArrayOfDouble);
  }
  
  @NotNull
  public static final Sequence<Float> asSequence(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$asSequence");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.6(paramArrayOfFloat);
  }
  
  @NotNull
  public static final Sequence<Integer> asSequence(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asSequence");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.4(paramArrayOfInt);
  }
  
  @NotNull
  public static final Sequence<Long> asSequence(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asSequence");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.5(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> Sequence<T> asSequence(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$asSequence");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.1(paramArrayOfT);
  }
  
  @NotNull
  public static final Sequence<Short> asSequence(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asSequence");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.3(paramArrayOfShort);
  }
  
  @NotNull
  public static final Sequence<Boolean> asSequence(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$asSequence");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return SequencesKt.emptySequence();
    }
    return (Sequence)new ArraysKt___ArraysKt.asSequence..inlined.Sequence.8(paramArrayOfBoolean);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfByte.length), 16));
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfChar.length), 16));
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfDouble.length), 16));
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfFloat.length), 16));
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfInt.length), 16));
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfLong.length), 16));
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associate(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfT.length), 16));
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramArrayOfT[i]);
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfShort.length), 16));
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfBoolean.length), 16));
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Byte> associateBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfByte.length), 16));
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      localMap.put(paramFunction1.invoke(Byte.valueOf(b)), Byte.valueOf(b));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends K> paramFunction1, @NotNull Function1<? super Byte, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfByte.length), 16));
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      localMap.put(paramFunction1.invoke(Byte.valueOf(b)), paramFunction11.invoke(Byte.valueOf(b)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Character> associateBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfChar.length), 16));
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfChar.length), 16));
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Double> associateBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfDouble.length), 16));
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      localMap.put(paramFunction1.invoke(Double.valueOf(d)), Double.valueOf(d));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends K> paramFunction1, @NotNull Function1<? super Double, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfDouble.length), 16));
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      localMap.put(paramFunction1.invoke(Double.valueOf(d)), paramFunction11.invoke(Double.valueOf(d)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Float> associateBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfFloat.length), 16));
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      localMap.put(paramFunction1.invoke(Float.valueOf(f)), Float.valueOf(f));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends K> paramFunction1, @NotNull Function1<? super Float, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfFloat.length), 16));
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      localMap.put(paramFunction1.invoke(Float.valueOf(f)), paramFunction11.invoke(Float.valueOf(f)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Integer> associateBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfInt.length), 16));
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localMap.put(paramFunction1.invoke(Integer.valueOf(k)), Integer.valueOf(k));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends K> paramFunction1, @NotNull Function1<? super Integer, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfInt.length), 16));
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localMap.put(paramFunction1.invoke(Integer.valueOf(k)), paramFunction11.invoke(Integer.valueOf(k)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Long> associateBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfLong.length), 16));
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      localMap.put(paramFunction1.invoke(Long.valueOf(l)), Long.valueOf(l));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends K> paramFunction1, @NotNull Function1<? super Long, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfLong.length), 16));
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      localMap.put(paramFunction1.invoke(Long.valueOf(l)), paramFunction11.invoke(Long.valueOf(l)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K> Map<K, T> associateBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfT.length), 16));
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      localMap.put(paramFunction1.invoke(?), ?);
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, V> associateBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfT.length), 16));
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      localMap.put(paramFunction1.invoke(?), paramFunction11.invoke(?));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Short> associateBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfShort.length), 16));
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      localMap.put(paramFunction1.invoke(Short.valueOf(s)), Short.valueOf(s));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends K> paramFunction1, @NotNull Function1<? super Short, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfShort.length), 16));
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      localMap.put(paramFunction1.invoke(Short.valueOf(s)), paramFunction11.invoke(Short.valueOf(s)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Boolean> associateBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfBoolean.length), 16));
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      localMap.put(paramFunction1.invoke(Boolean.valueOf(k)), Boolean.valueOf(k));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends K> paramFunction1, @NotNull Function1<? super Boolean, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramArrayOfBoolean.length), 16));
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      localMap.put(paramFunction1.invoke(Boolean.valueOf(k)), paramFunction11.invoke(Boolean.valueOf(k)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(@NotNull byte[] paramArrayOfByte, @NotNull M paramM, @NotNull Function1<? super Byte, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      paramM.put(paramFunction1.invoke(Byte.valueOf(b)), Byte.valueOf(b));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull byte[] paramArrayOfByte, @NotNull M paramM, @NotNull Function1<? super Byte, ? extends K> paramFunction1, @NotNull Function1<? super Byte, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      paramM.put(paramFunction1.invoke(Byte.valueOf(b)), paramFunction11.invoke(Byte.valueOf(b)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull char[] paramArrayOfChar, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull char[] paramArrayOfChar, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(@NotNull double[] paramArrayOfDouble, @NotNull M paramM, @NotNull Function1<? super Double, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      paramM.put(paramFunction1.invoke(Double.valueOf(d)), Double.valueOf(d));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull double[] paramArrayOfDouble, @NotNull M paramM, @NotNull Function1<? super Double, ? extends K> paramFunction1, @NotNull Function1<? super Double, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      paramM.put(paramFunction1.invoke(Double.valueOf(d)), paramFunction11.invoke(Double.valueOf(d)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(@NotNull float[] paramArrayOfFloat, @NotNull M paramM, @NotNull Function1<? super Float, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      paramM.put(paramFunction1.invoke(Float.valueOf(f)), Float.valueOf(f));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull float[] paramArrayOfFloat, @NotNull M paramM, @NotNull Function1<? super Float, ? extends K> paramFunction1, @NotNull Function1<? super Float, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      paramM.put(paramFunction1.invoke(Float.valueOf(f)), paramFunction11.invoke(Float.valueOf(f)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(@NotNull int[] paramArrayOfInt, @NotNull M paramM, @NotNull Function1<? super Integer, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      paramM.put(paramFunction1.invoke(Integer.valueOf(k)), Integer.valueOf(k));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull int[] paramArrayOfInt, @NotNull M paramM, @NotNull Function1<? super Integer, ? extends K> paramFunction1, @NotNull Function1<? super Integer, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      paramM.put(paramFunction1.invoke(Integer.valueOf(k)), paramFunction11.invoke(Integer.valueOf(k)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(@NotNull long[] paramArrayOfLong, @NotNull M paramM, @NotNull Function1<? super Long, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      paramM.put(paramFunction1.invoke(Long.valueOf(l)), Long.valueOf(l));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull long[] paramArrayOfLong, @NotNull M paramM, @NotNull Function1<? super Long, ? extends K> paramFunction1, @NotNull Function1<? super Long, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      paramM.put(paramFunction1.invoke(Long.valueOf(l)), paramFunction11.invoke(Long.valueOf(l)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull T[] paramArrayOfT, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      paramM.put(paramFunction1.invoke(?), ?);
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull T[] paramArrayOfT, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      paramM.put(paramFunction1.invoke(?), paramFunction11.invoke(?));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(@NotNull short[] paramArrayOfShort, @NotNull M paramM, @NotNull Function1<? super Short, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      paramM.put(paramFunction1.invoke(Short.valueOf(s)), Short.valueOf(s));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull short[] paramArrayOfShort, @NotNull M paramM, @NotNull Function1<? super Short, ? extends K> paramFunction1, @NotNull Function1<? super Short, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      paramM.put(paramFunction1.invoke(Short.valueOf(s)), paramFunction11.invoke(Short.valueOf(s)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull M paramM, @NotNull Function1<? super Boolean, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      paramM.put(paramFunction1.invoke(Boolean.valueOf(k)), Boolean.valueOf(k));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull M paramM, @NotNull Function1<? super Boolean, ? extends K> paramFunction1, @NotNull Function1<? super Boolean, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      paramM.put(paramFunction1.invoke(Boolean.valueOf(k)), paramFunction11.invoke(Boolean.valueOf(k)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull byte[] paramArrayOfByte, @NotNull M paramM, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull char[] paramArrayOfChar, @NotNull M paramM, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull double[] paramArrayOfDouble, @NotNull M paramM, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull float[] paramArrayOfFloat, @NotNull M paramM, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull int[] paramArrayOfInt, @NotNull M paramM, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull long[] paramArrayOfLong, @NotNull M paramM, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull T[] paramArrayOfT, @NotNull M paramM, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(paramArrayOfT[i]);
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull short[] paramArrayOfShort, @NotNull M paramM, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull M paramM, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = (Pair)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  public static final double average(@NotNull byte[] paramArrayOfByte)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfByte[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  public static final double average(@NotNull double[] paramArrayOfDouble)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfDouble.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfDouble[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  public static final double average(@NotNull float[] paramArrayOfFloat)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfFloat.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfFloat[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  public static final double average(@NotNull int[] paramArrayOfInt)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfInt.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfInt[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  public static final double average(@NotNull long[] paramArrayOfLong)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfLong.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfLong[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  public static final double average(@NotNull short[] paramArrayOfShort)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfShort.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfShort[i];
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfByte")
  public static final double averageOfByte(@NotNull Byte[] paramArrayOfByte)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfByte[i].byteValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfDouble")
  public static final double averageOfDouble(@NotNull Double[] paramArrayOfDouble)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfDouble.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfDouble[i].doubleValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfFloat")
  public static final double averageOfFloat(@NotNull Float[] paramArrayOfFloat)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfFloat.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfFloat[i].floatValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfInt")
  public static final double averageOfInt(@NotNull Integer[] paramArrayOfInteger)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInteger, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfInteger.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfInteger[i].intValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfLong")
  public static final double averageOfLong(@NotNull Long[] paramArrayOfLong)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfLong.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfLong[i].longValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @JvmName(name="averageOfShort")
  public static final double averageOfShort(@NotNull Short[] paramArrayOfShort)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfShort.length;
    int j = 0;
    while (i < k)
    {
      d += paramArrayOfShort[i].shortValue();
      j += 1;
      i += 1;
    }
    if (j == 0) {
      return DoubleCompanionObject.INSTANCE.getNaN();
    }
    return d / j;
  }
  
  @InlineOnly
  private static final byte component1(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component1");
    return paramArrayOfByte[0];
  }
  
  @InlineOnly
  private static final char component1(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$component1");
    return paramArrayOfChar[0];
  }
  
  @InlineOnly
  private static final double component1(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$component1");
    return paramArrayOfDouble[0];
  }
  
  @InlineOnly
  private static final float component1(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$component1");
    return paramArrayOfFloat[0];
  }
  
  @InlineOnly
  private static final int component1(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component1");
    return paramArrayOfInt[0];
  }
  
  @InlineOnly
  private static final long component1(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component1");
    return paramArrayOfLong[0];
  }
  
  @InlineOnly
  private static final <T> T component1(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$component1");
    return paramArrayOfT[0];
  }
  
  @InlineOnly
  private static final short component1(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component1");
    return paramArrayOfShort[0];
  }
  
  @InlineOnly
  private static final boolean component1(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$component1");
    return paramArrayOfBoolean[0];
  }
  
  @InlineOnly
  private static final byte component2(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component2");
    return paramArrayOfByte[1];
  }
  
  @InlineOnly
  private static final char component2(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$component2");
    return paramArrayOfChar[1];
  }
  
  @InlineOnly
  private static final double component2(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$component2");
    return paramArrayOfDouble[1];
  }
  
  @InlineOnly
  private static final float component2(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$component2");
    return paramArrayOfFloat[1];
  }
  
  @InlineOnly
  private static final int component2(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component2");
    return paramArrayOfInt[1];
  }
  
  @InlineOnly
  private static final long component2(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component2");
    return paramArrayOfLong[1];
  }
  
  @InlineOnly
  private static final <T> T component2(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$component2");
    return paramArrayOfT[1];
  }
  
  @InlineOnly
  private static final short component2(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component2");
    return paramArrayOfShort[1];
  }
  
  @InlineOnly
  private static final boolean component2(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$component2");
    return paramArrayOfBoolean[1];
  }
  
  @InlineOnly
  private static final byte component3(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component3");
    return paramArrayOfByte[2];
  }
  
  @InlineOnly
  private static final char component3(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$component3");
    return paramArrayOfChar[2];
  }
  
  @InlineOnly
  private static final double component3(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$component3");
    return paramArrayOfDouble[2];
  }
  
  @InlineOnly
  private static final float component3(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$component3");
    return paramArrayOfFloat[2];
  }
  
  @InlineOnly
  private static final int component3(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component3");
    return paramArrayOfInt[2];
  }
  
  @InlineOnly
  private static final long component3(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component3");
    return paramArrayOfLong[2];
  }
  
  @InlineOnly
  private static final <T> T component3(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$component3");
    return paramArrayOfT[2];
  }
  
  @InlineOnly
  private static final short component3(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component3");
    return paramArrayOfShort[2];
  }
  
  @InlineOnly
  private static final boolean component3(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$component3");
    return paramArrayOfBoolean[2];
  }
  
  @InlineOnly
  private static final byte component4(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component4");
    return paramArrayOfByte[3];
  }
  
  @InlineOnly
  private static final char component4(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$component4");
    return paramArrayOfChar[3];
  }
  
  @InlineOnly
  private static final double component4(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$component4");
    return paramArrayOfDouble[3];
  }
  
  @InlineOnly
  private static final float component4(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$component4");
    return paramArrayOfFloat[3];
  }
  
  @InlineOnly
  private static final int component4(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component4");
    return paramArrayOfInt[3];
  }
  
  @InlineOnly
  private static final long component4(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component4");
    return paramArrayOfLong[3];
  }
  
  @InlineOnly
  private static final <T> T component4(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$component4");
    return paramArrayOfT[3];
  }
  
  @InlineOnly
  private static final short component4(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component4");
    return paramArrayOfShort[3];
  }
  
  @InlineOnly
  private static final boolean component4(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$component4");
    return paramArrayOfBoolean[3];
  }
  
  @InlineOnly
  private static final byte component5(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component5");
    return paramArrayOfByte[4];
  }
  
  @InlineOnly
  private static final char component5(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$component5");
    return paramArrayOfChar[4];
  }
  
  @InlineOnly
  private static final double component5(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$component5");
    return paramArrayOfDouble[4];
  }
  
  @InlineOnly
  private static final float component5(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$component5");
    return paramArrayOfFloat[4];
  }
  
  @InlineOnly
  private static final int component5(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component5");
    return paramArrayOfInt[4];
  }
  
  @InlineOnly
  private static final long component5(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component5");
    return paramArrayOfLong[4];
  }
  
  @InlineOnly
  private static final <T> T component5(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$component5");
    return paramArrayOfT[4];
  }
  
  @InlineOnly
  private static final short component5(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component5");
    return paramArrayOfShort[4];
  }
  
  @InlineOnly
  private static final boolean component5(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$component5");
    return paramArrayOfBoolean[4];
  }
  
  public static final boolean contains(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfByte, paramByte) >= 0;
  }
  
  public static final boolean contains(@NotNull char[] paramArrayOfChar, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfChar, paramChar) >= 0;
  }
  
  public static final boolean contains(@NotNull double[] paramArrayOfDouble, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfDouble, paramDouble) >= 0;
  }
  
  public static final boolean contains(@NotNull float[] paramArrayOfFloat, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfFloat, paramFloat) >= 0;
  }
  
  public static final boolean contains(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfInt, paramInt) >= 0;
  }
  
  public static final boolean contains(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfLong, paramLong) >= 0;
  }
  
  public static final <T> boolean contains(@NotNull T[] paramArrayOfT, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfT, paramT) >= 0;
  }
  
  public static final boolean contains(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfShort, paramShort) >= 0;
  }
  
  public static final boolean contains(@NotNull boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$contains");
    return ArraysKt.indexOf(paramArrayOfBoolean, paramBoolean) >= 0;
  }
  
  @InlineOnly
  private static final int count(@NotNull byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length;
  }
  
  public static final int count(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull char[] paramArrayOfChar)
  {
    return paramArrayOfChar.length;
  }
  
  public static final int count(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfChar.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull double[] paramArrayOfDouble)
  {
    return paramArrayOfDouble.length;
  }
  
  public static final int count(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfDouble.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat.length;
  }
  
  public static final int count(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length;
  }
  
  public static final int count(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length;
  }
  
  public static final int count(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfLong.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final <T> int count(@NotNull T[] paramArrayOfT)
  {
    return paramArrayOfT.length;
  }
  
  public static final <T> int count(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(paramArrayOfT[j])).booleanValue()) {
        break label59;
      }
      i += 1;
    }
    label59:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull short[] paramArrayOfShort)
  {
    return paramArrayOfShort.length;
  }
  
  public static final int count(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfShort.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @InlineOnly
  private static final int count(@NotNull boolean[] paramArrayOfBoolean)
  {
    return paramArrayOfBoolean.length;
  }
  
  public static final int count(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfBoolean.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[j]))).booleanValue()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @NotNull
  public static final List<Byte> distinct(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfByte));
  }
  
  @NotNull
  public static final List<Character> distinct(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfChar));
  }
  
  @NotNull
  public static final List<Double> distinct(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfDouble));
  }
  
  @NotNull
  public static final List<Float> distinct(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfFloat));
  }
  
  @NotNull
  public static final List<Integer> distinct(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfInt));
  }
  
  @NotNull
  public static final List<Long> distinct(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfLong));
  }
  
  @NotNull
  public static final <T> List<T> distinct(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfT));
  }
  
  @NotNull
  public static final List<Short> distinct(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfShort));
  }
  
  @NotNull
  public static final List<Boolean> distinct(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$distinct");
    return CollectionsKt.toList((Iterable)ArraysKt.toMutableSet(paramArrayOfBoolean));
  }
  
  @NotNull
  public static final <K> List<Byte> distinctBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (localHashSet.add(paramFunction1.invoke(Byte.valueOf(b)))) {
        localArrayList.add(Byte.valueOf(b));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Character> distinctBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (localHashSet.add(paramFunction1.invoke(Character.valueOf(c)))) {
        localArrayList.add(Character.valueOf(c));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Double> distinctBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (localHashSet.add(paramFunction1.invoke(Double.valueOf(d)))) {
        localArrayList.add(Double.valueOf(d));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Float> distinctBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (localHashSet.add(paramFunction1.invoke(Float.valueOf(f)))) {
        localArrayList.add(Float.valueOf(f));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Integer> distinctBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (localHashSet.add(paramFunction1.invoke(Integer.valueOf(k)))) {
        localArrayList.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Long> distinctBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (localHashSet.add(paramFunction1.invoke(Long.valueOf(l)))) {
        localArrayList.add(Long.valueOf(l));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T, K> List<T> distinctBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (localHashSet.add(paramFunction1.invoke(?))) {
        localArrayList.add(?);
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Short> distinctBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (localHashSet.add(paramFunction1.invoke(Short.valueOf(s)))) {
        localArrayList.add(Short.valueOf(s));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <K> List<Boolean> distinctBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$distinctBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (localHashSet.add(paramFunction1.invoke(Boolean.valueOf(k)))) {
        localArrayList.add(Boolean.valueOf(k));
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Byte> drop(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfByte, RangesKt.coerceAtLeast(paramArrayOfByte.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Character> drop(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfChar, RangesKt.coerceAtLeast(paramArrayOfChar.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Double> drop(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfDouble, RangesKt.coerceAtLeast(paramArrayOfDouble.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Float> drop(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfFloat, RangesKt.coerceAtLeast(paramArrayOfFloat.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Integer> drop(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfInt, RangesKt.coerceAtLeast(paramArrayOfInt.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Long> drop(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfLong, RangesKt.coerceAtLeast(paramArrayOfLong.length - paramInt, 0));
  }
  
  @NotNull
  public static final <T> List<T> drop(@NotNull T[] paramArrayOfT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfT, RangesKt.coerceAtLeast(paramArrayOfT.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Short> drop(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfShort, RangesKt.coerceAtLeast(paramArrayOfShort.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Boolean> drop(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.takeLast(paramArrayOfBoolean, RangesKt.coerceAtLeast(paramArrayOfBoolean.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Byte> dropLast(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfByte, RangesKt.coerceAtLeast(paramArrayOfByte.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Character> dropLast(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfChar, RangesKt.coerceAtLeast(paramArrayOfChar.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Double> dropLast(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfDouble, RangesKt.coerceAtLeast(paramArrayOfDouble.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Float> dropLast(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfFloat, RangesKt.coerceAtLeast(paramArrayOfFloat.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Integer> dropLast(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfInt, RangesKt.coerceAtLeast(paramArrayOfInt.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Long> dropLast(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfLong, RangesKt.coerceAtLeast(paramArrayOfLong.length - paramInt, 0));
  }
  
  @NotNull
  public static final <T> List<T> dropLast(@NotNull T[] paramArrayOfT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfT, RangesKt.coerceAtLeast(paramArrayOfT.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Short> dropLast(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfShort, RangesKt.coerceAtLeast(paramArrayOfShort.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Boolean> dropLast(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return ArraysKt.take(paramArrayOfBoolean, RangesKt.coerceAtLeast(paramArrayOfBoolean.length - paramInt, 0));
  }
  
  @NotNull
  public static final List<Byte> dropLastWhile(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfByte, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Character> dropLastWhile(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfChar);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfChar, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Double> dropLastWhile(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfDouble);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfDouble, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Float> dropLastWhile(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfFloat);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfFloat, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Integer> dropLastWhile(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfInt, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Long> dropLastWhile(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfLong, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <T> List<T> dropLastWhile(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfT);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return ArraysKt.take(paramArrayOfT, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Short> dropLastWhile(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfShort, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Boolean> dropLastWhile(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfBoolean);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return ArraysKt.take(paramArrayOfBoolean, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Byte> dropWhile(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    byte b;
    if (j < k)
    {
      b = paramArrayOfByte[j];
      if (i != 0) {
        localArrayList.add(Byte.valueOf(b));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue())
      {
        localArrayList.add(Byte.valueOf(b));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Character> dropWhile(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfChar.length;
    int j = 0;
    int i = 0;
    char c;
    if (j < k)
    {
      c = paramArrayOfChar[j];
      if (i != 0) {
        localArrayList.add(Character.valueOf(c));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue())
      {
        localArrayList.add(Character.valueOf(c));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Double> dropWhile(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfDouble.length;
    int j = 0;
    int i = 0;
    double d;
    if (j < k)
    {
      d = paramArrayOfDouble[j];
      if (i != 0) {
        localArrayList.add(Double.valueOf(d));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue())
      {
        localArrayList.add(Double.valueOf(d));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Float> dropWhile(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfFloat.length;
    int j = 0;
    int i = 0;
    float f;
    if (j < k)
    {
      f = paramArrayOfFloat[j];
      if (i != 0) {
        localArrayList.add(Float.valueOf(f));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue())
      {
        localArrayList.add(Float.valueOf(f));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Integer> dropWhile(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    int m;
    if (j < k)
    {
      m = paramArrayOfInt[j];
      if (i != 0) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(m))).booleanValue())
      {
        localArrayList.add(Integer.valueOf(m));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Long> dropWhile(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfLong.length;
    int j = 0;
    int i = 0;
    long l;
    if (j < k)
    {
      l = paramArrayOfLong[j];
      if (i != 0) {
        localArrayList.add(Long.valueOf(l));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue())
      {
        localArrayList.add(Long.valueOf(l));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final <T> List<T> dropWhile(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    T ?;
    if (j < k)
    {
      ? = paramArrayOfT[j];
      if (i != 0) {
        localArrayList.add(?);
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(?)).booleanValue())
      {
        localArrayList.add(?);
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Short> dropWhile(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfShort.length;
    int j = 0;
    int i = 0;
    short s;
    if (j < k)
    {
      s = paramArrayOfShort[j];
      if (i != 0) {
        localArrayList.add(Short.valueOf(s));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue())
      {
        localArrayList.add(Short.valueOf(s));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @NotNull
  public static final List<Boolean> dropWhile(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfBoolean.length;
    int j = 0;
    int i = 0;
    int m;
    if (j < k)
    {
      m = paramArrayOfBoolean[j];
      if (i != 0) {
        localArrayList.add(Boolean.valueOf(m));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(m))).booleanValue())
      {
        localArrayList.add(Boolean.valueOf(m));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @InlineOnly
  private static final byte elementAtOrElse(@NotNull byte[] paramArrayOfByte, int paramInt, Function1<? super Integer, Byte> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return paramArrayOfByte[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).byteValue();
  }
  
  @InlineOnly
  private static final char elementAtOrElse(@NotNull char[] paramArrayOfChar, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfChar))) {
      return paramArrayOfChar[paramInt];
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  @InlineOnly
  private static final double elementAtOrElse(@NotNull double[] paramArrayOfDouble, int paramInt, Function1<? super Integer, Double> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfDouble))) {
      return paramArrayOfDouble[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).doubleValue();
  }
  
  @InlineOnly
  private static final float elementAtOrElse(@NotNull float[] paramArrayOfFloat, int paramInt, Function1<? super Integer, Float> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfFloat))) {
      return paramArrayOfFloat[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).floatValue();
  }
  
  @InlineOnly
  private static final int elementAtOrElse(@NotNull int[] paramArrayOfInt, int paramInt, Function1<? super Integer, Integer> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return paramArrayOfInt[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).intValue();
  }
  
  @InlineOnly
  private static final long elementAtOrElse(@NotNull long[] paramArrayOfLong, int paramInt, Function1<? super Integer, Long> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return paramArrayOfLong[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).longValue();
  }
  
  @InlineOnly
  private static final <T> T elementAtOrElse(@NotNull T[] paramArrayOfT, int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfT))) {
      return paramArrayOfT[paramInt];
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @InlineOnly
  private static final short elementAtOrElse(@NotNull short[] paramArrayOfShort, int paramInt, Function1<? super Integer, Short> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return paramArrayOfShort[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).shortValue();
  }
  
  @InlineOnly
  private static final boolean elementAtOrElse(@NotNull boolean[] paramArrayOfBoolean, int paramInt, Function1<? super Integer, Boolean> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfBoolean))) {
      return paramArrayOfBoolean[paramInt];
    }
    return ((Boolean)paramFunction1.invoke(Integer.valueOf(paramInt))).booleanValue();
  }
  
  @InlineOnly
  private static final Boolean elementAtOrNull(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfBoolean, paramInt);
  }
  
  @InlineOnly
  private static final Byte elementAtOrNull(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfByte, paramInt);
  }
  
  @InlineOnly
  private static final Character elementAtOrNull(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfChar, paramInt);
  }
  
  @InlineOnly
  private static final Double elementAtOrNull(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfDouble, paramInt);
  }
  
  @InlineOnly
  private static final Float elementAtOrNull(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfFloat, paramInt);
  }
  
  @InlineOnly
  private static final Integer elementAtOrNull(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfInt, paramInt);
  }
  
  @InlineOnly
  private static final Long elementAtOrNull(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfLong, paramInt);
  }
  
  @InlineOnly
  private static final <T> T elementAtOrNull(@NotNull T[] paramArrayOfT, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfT, paramInt);
  }
  
  @InlineOnly
  private static final Short elementAtOrNull(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    return ArraysKt.getOrNull(paramArrayOfShort, paramInt);
  }
  
  @NotNull
  public static final List<Byte> filter(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        localCollection.add(Byte.valueOf(b));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Character> filter(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localCollection.add(Character.valueOf(c));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Double> filter(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        localCollection.add(Double.valueOf(d));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Float> filter(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        localCollection.add(Float.valueOf(f));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Integer> filter(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        localCollection.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Long> filter(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        localCollection.add(Long.valueOf(l));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filter(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        localCollection.add(?);
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Short> filter(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        localCollection.add(Short.valueOf(s));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Boolean> filter(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        localCollection.add(Boolean.valueOf(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Byte> filterIndexed(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Integer, ? super Byte, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Byte.valueOf(b))).booleanValue()) {
        localCollection.add(Byte.valueOf(b));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Character> filterIndexed(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfChar.length;
    int j = 0;
    while (j < k)
    {
      char c = paramArrayOfChar[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        localCollection.add(Character.valueOf(c));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Double> filterIndexed(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Integer, ? super Double, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfDouble.length;
    int j = 0;
    while (j < k)
    {
      double d = paramArrayOfDouble[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Double.valueOf(d))).booleanValue()) {
        localCollection.add(Double.valueOf(d));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Float> filterIndexed(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Integer, ? super Float, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfFloat.length;
    int j = 0;
    while (j < k)
    {
      float f = paramArrayOfFloat[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Float.valueOf(f))).booleanValue()) {
        localCollection.add(Float.valueOf(f));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Integer> filterIndexed(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfInt[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Integer.valueOf(m))).booleanValue()) {
        localCollection.add(Integer.valueOf(m));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Long> filterIndexed(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Integer, ? super Long, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfLong.length;
    int j = 0;
    while (j < k)
    {
      long l = paramArrayOfLong[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Long.valueOf(l))).booleanValue()) {
        localCollection.add(Long.valueOf(l));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filterIndexed(@NotNull T[] paramArrayOfT, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfT.length;
    int j = 0;
    while (j < k)
    {
      T ? = paramArrayOfT[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), ?)).booleanValue()) {
        localCollection.add(?);
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Short> filterIndexed(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Integer, ? super Short, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfShort.length;
    int j = 0;
    while (j < k)
    {
      short s = paramArrayOfShort[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Short.valueOf(s))).booleanValue()) {
        localCollection.add(Short.valueOf(s));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Boolean> filterIndexed(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Integer, ? super Boolean, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfBoolean.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfBoolean[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Boolean.valueOf(m))).booleanValue()) {
        localCollection.add(Boolean.valueOf(m));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <C extends Collection<? super Byte>> C filterIndexedTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Byte, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Byte.valueOf(b))).booleanValue()) {
        paramC.add(Byte.valueOf(b));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Character>> C filterIndexedTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfChar.length;
    int j = 0;
    while (j < k)
    {
      char c = paramArrayOfChar[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        paramC.add(Character.valueOf(c));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Double>> C filterIndexedTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Double, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfDouble.length;
    int j = 0;
    while (j < k)
    {
      double d = paramArrayOfDouble[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Double.valueOf(d))).booleanValue()) {
        paramC.add(Double.valueOf(d));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Float>> C filterIndexedTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Float, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfFloat.length;
    int j = 0;
    while (j < k)
    {
      float f = paramArrayOfFloat[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Float.valueOf(f))).booleanValue()) {
        paramC.add(Float.valueOf(f));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Integer>> C filterIndexedTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Integer, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfInt[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Integer.valueOf(m))).booleanValue()) {
        paramC.add(Integer.valueOf(m));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Long>> C filterIndexedTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Long, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfLong.length;
    int j = 0;
    while (j < k)
    {
      long l = paramArrayOfLong[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Long.valueOf(l))).booleanValue()) {
        paramC.add(Long.valueOf(l));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfT.length;
    int j = 0;
    while (j < k)
    {
      T ? = paramArrayOfT[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), ?)).booleanValue()) {
        paramC.add(?);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Short>> C filterIndexedTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Short, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfShort.length;
    int j = 0;
    while (j < k)
    {
      short s = paramArrayOfShort[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Short.valueOf(s))).booleanValue()) {
        paramC.add(Short.valueOf(s));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Boolean>> C filterIndexedTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Boolean, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int k = paramArrayOfBoolean.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfBoolean[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Boolean.valueOf(m))).booleanValue()) {
        paramC.add(Boolean.valueOf(m));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final List<Byte> filterNot(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        localCollection.add(Byte.valueOf(b));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Character> filterNot(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localCollection.add(Character.valueOf(c));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Double> filterNot(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        localCollection.add(Double.valueOf(d));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Float> filterNot(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        localCollection.add(Float.valueOf(f));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Integer> filterNot(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        localCollection.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Long> filterNot(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        localCollection.add(Long.valueOf(l));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filterNot(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (!((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        localCollection.add(?);
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Short> filterNot(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        localCollection.add(Short.valueOf(s));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final List<Boolean> filterNot(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        localCollection.add(Boolean.valueOf(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T> List<T> filterNotNull(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterNotNull");
    return (List)ArraysKt.filterNotNullTo(paramArrayOfT, (Collection)new ArrayList());
  }
  
  @NotNull
  public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull T[] paramArrayOfT, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? != null) {
        paramC.add(?);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Byte>> C filterNotTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        paramC.add(Byte.valueOf(b));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Character>> C filterNotTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.add(Character.valueOf(c));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Double>> C filterNotTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        paramC.add(Double.valueOf(d));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Float>> C filterNotTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        paramC.add(Float.valueOf(f));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Integer>> C filterNotTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        paramC.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Long>> C filterNotTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        paramC.add(Long.valueOf(l));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (!((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        paramC.add(?);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Short>> C filterNotTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        paramC.add(Short.valueOf(s));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Boolean>> C filterNotTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        paramC.add(Boolean.valueOf(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Byte>> C filterTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        paramC.add(Byte.valueOf(b));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Character>> C filterTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.add(Character.valueOf(c));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Double>> C filterTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        paramC.add(Double.valueOf(d));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Float>> C filterTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        paramC.add(Float.valueOf(f));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Integer>> C filterTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        paramC.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Long>> C filterTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        paramC.add(Long.valueOf(l));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C filterTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        paramC.add(?);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Short>> C filterTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        paramC.add(Short.valueOf(s));
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Boolean>> C filterTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        paramC.add(Boolean.valueOf(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @InlineOnly
  private static final Boolean find(@NotNull boolean[] paramArrayOfBoolean, Function1<? super Boolean, Boolean> paramFunction1)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        return Boolean.valueOf(k);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Byte find(@NotNull byte[] paramArrayOfByte, Function1<? super Byte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return Byte.valueOf(b);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Character find(@NotNull char[] paramArrayOfChar, Function1<? super Character, Boolean> paramFunction1)
  {
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Double find(@NotNull double[] paramArrayOfDouble, Function1<? super Double, Boolean> paramFunction1)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return Double.valueOf(d);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Float find(@NotNull float[] paramArrayOfFloat, Function1<? super Float, Boolean> paramFunction1)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return Float.valueOf(f);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Integer find(@NotNull int[] paramArrayOfInt, Function1<? super Integer, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        return Integer.valueOf(k);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Long find(@NotNull long[] paramArrayOfLong, Function1<? super Long, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return Long.valueOf(l);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final <T> T find(@NotNull T[] paramArrayOfT, Function1<? super T, Boolean> paramFunction1)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Short find(@NotNull short[] paramArrayOfShort, Function1<? super Short, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return Short.valueOf(s);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Boolean findLast(@NotNull boolean[] paramArrayOfBoolean, Function1<? super Boolean, Boolean> paramFunction1)
  {
    int i = paramArrayOfBoolean.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(j))).booleanValue()) {
        return Boolean.valueOf(j);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Byte findLast(@NotNull byte[] paramArrayOfByte, Function1<? super Byte, Boolean> paramFunction1)
  {
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return Byte.valueOf(b);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Character findLast(@NotNull char[] paramArrayOfChar, Function1<? super Character, Boolean> paramFunction1)
  {
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Double findLast(@NotNull double[] paramArrayOfDouble, Function1<? super Double, Boolean> paramFunction1)
  {
    int i = paramArrayOfDouble.length - 1;
    while (i >= 0)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return Double.valueOf(d);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Float findLast(@NotNull float[] paramArrayOfFloat, Function1<? super Float, Boolean> paramFunction1)
  {
    int i = paramArrayOfFloat.length - 1;
    while (i >= 0)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return Float.valueOf(f);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Integer findLast(@NotNull int[] paramArrayOfInt, Function1<? super Integer, Boolean> paramFunction1)
  {
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(j))).booleanValue()) {
        return Integer.valueOf(j);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Long findLast(@NotNull long[] paramArrayOfLong, Function1<? super Long, Boolean> paramFunction1)
  {
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return Long.valueOf(l);
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final <T> T findLast(@NotNull T[] paramArrayOfT, Function1<? super T, Boolean> paramFunction1)
  {
    int i = paramArrayOfT.length - 1;
    while (i >= 0)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i -= 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Short findLast(@NotNull short[] paramArrayOfShort, Function1<? super Short, Boolean> paramFunction1)
  {
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return Short.valueOf(s);
      }
      i -= 1;
    }
    return null;
  }
  
  public static final byte first(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$first");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfByte[0];
  }
  
  public static final byte first(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return b;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final char first(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$first");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfChar[0];
  }
  
  public static final char first(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return c;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final double first(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$first");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfDouble[0];
  }
  
  public static final double first(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return d;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final float first(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$first");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfFloat[0];
  }
  
  public static final float first(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return f;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final int first(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$first");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfInt[0];
  }
  
  public static final int first(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        return k;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final long first(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$first");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfLong[0];
  }
  
  public static final long first(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return l;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final <T> T first(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$first");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfT[0];
  }
  
  public static final <T> T first(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final short first(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$first");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfShort[0];
  }
  
  public static final short first(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return s;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final boolean first(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$first");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfBoolean[0];
  }
  
  public static final boolean first(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        return k;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @Nullable
  public static final Boolean firstOrNull(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$firstOrNull");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Boolean.valueOf(paramArrayOfBoolean[0]);
  }
  
  @Nullable
  public static final Boolean firstOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        return Boolean.valueOf(k);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Byte firstOrNull(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$firstOrNull");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Byte.valueOf(paramArrayOfByte[0]);
  }
  
  @Nullable
  public static final Byte firstOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return Byte.valueOf(b);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Character firstOrNull(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$firstOrNull");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramArrayOfChar[0]);
  }
  
  @Nullable
  public static final Character firstOrNull(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Double firstOrNull(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$firstOrNull");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Double.valueOf(paramArrayOfDouble[0]);
  }
  
  @Nullable
  public static final Double firstOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return Double.valueOf(d);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Float firstOrNull(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$firstOrNull");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Float.valueOf(paramArrayOfFloat[0]);
  }
  
  @Nullable
  public static final Float firstOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return Float.valueOf(f);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Integer firstOrNull(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$firstOrNull");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Integer.valueOf(paramArrayOfInt[0]);
  }
  
  @Nullable
  public static final Integer firstOrNull(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        return Integer.valueOf(k);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Long firstOrNull(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$firstOrNull");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Long.valueOf(paramArrayOfLong[0]);
  }
  
  @Nullable
  public static final Long firstOrNull(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return Long.valueOf(l);
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$firstOrNull");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return paramArrayOfT[0];
  }
  
  @Nullable
  public static final <T> T firstOrNull(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  public static final Short firstOrNull(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$firstOrNull");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Short.valueOf(paramArrayOfShort[0]);
  }
  
  @Nullable
  public static final Short firstOrNull(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return Short.valueOf(s);
      }
      i += 1;
    }
    return null;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> flatMap(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(paramArrayOfT[i]));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function1<? super T, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(paramArrayOfT[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i])));
      i += 1;
    }
    return paramC;
  }
  
  public static final <R> R fold(@NotNull byte[] paramArrayOfByte, R paramR, @NotNull Function2<? super R, ? super Byte, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull char[] paramArrayOfChar, R paramR, @NotNull Function2<? super R, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Character.valueOf(paramArrayOfChar[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull double[] paramArrayOfDouble, R paramR, @NotNull Function2<? super R, ? super Double, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull float[] paramArrayOfFloat, R paramR, @NotNull Function2<? super R, ? super Float, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull int[] paramArrayOfInt, R paramR, @NotNull Function2<? super R, ? super Integer, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull long[] paramArrayOfLong, R paramR, @NotNull Function2<? super R, ? super Long, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <T, R> R fold(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, paramArrayOfT[i]);
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull short[] paramArrayOfShort, R paramR, @NotNull Function2<? super R, ? super Short, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R fold(@NotNull boolean[] paramArrayOfBoolean, R paramR, @NotNull Function2<? super R, ? super Boolean, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull byte[] paramArrayOfByte, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Byte, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      byte b = paramArrayOfByte[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Byte.valueOf(b));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull char[] paramArrayOfChar, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      char c = paramArrayOfChar[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Character.valueOf(c));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull double[] paramArrayOfDouble, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Double, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      double d = paramArrayOfDouble[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Double.valueOf(d));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull float[] paramArrayOfFloat, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Float, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      float f = paramArrayOfFloat[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Float.valueOf(f));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull int[] paramArrayOfInt, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfInt[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Integer.valueOf(n));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull long[] paramArrayOfLong, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      long l = paramArrayOfLong[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Long.valueOf(l));
      j += 1;
    }
    return paramR;
  }
  
  public static final <T, R> R foldIndexed(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      T ? = paramArrayOfT[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, ?);
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull short[] paramArrayOfShort, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Short, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      short s = paramArrayOfShort[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Short.valueOf(s));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull boolean[] paramArrayOfBoolean, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Boolean, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int m = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfBoolean[j];
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Boolean.valueOf(n));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull byte[] paramArrayOfByte, R paramR, @NotNull Function2<? super Byte, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Byte.valueOf(paramArrayOfByte[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull char[] paramArrayOfChar, R paramR, @NotNull Function2<? super Character, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfChar);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Character.valueOf(paramArrayOfChar[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull double[] paramArrayOfDouble, R paramR, @NotNull Function2<? super Double, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfDouble);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Double.valueOf(paramArrayOfDouble[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull float[] paramArrayOfFloat, R paramR, @NotNull Function2<? super Float, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfFloat);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Float.valueOf(paramArrayOfFloat[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull int[] paramArrayOfInt, R paramR, @NotNull Function2<? super Integer, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Integer.valueOf(paramArrayOfInt[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull long[] paramArrayOfLong, R paramR, @NotNull Function2<? super Long, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Long.valueOf(paramArrayOfLong[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <T, R> R foldRight(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function2<? super T, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfT);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(paramArrayOfT[i], paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull short[] paramArrayOfShort, R paramR, @NotNull Function2<? super Short, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Short.valueOf(paramArrayOfShort[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull boolean[] paramArrayOfBoolean, R paramR, @NotNull Function2<? super Boolean, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfBoolean);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull byte[] paramArrayOfByte, R paramR, @NotNull Function3<? super Integer, ? super Byte, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Byte.valueOf(paramArrayOfByte[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull char[] paramArrayOfChar, R paramR, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfChar);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramArrayOfChar[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull double[] paramArrayOfDouble, R paramR, @NotNull Function3<? super Integer, ? super Double, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfDouble);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Double.valueOf(paramArrayOfDouble[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull float[] paramArrayOfFloat, R paramR, @NotNull Function3<? super Integer, ? super Float, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfFloat);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Float.valueOf(paramArrayOfFloat[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull int[] paramArrayOfInt, R paramR, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Integer.valueOf(paramArrayOfInt[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull long[] paramArrayOfLong, R paramR, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Long.valueOf(paramArrayOfLong[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <T, R> R foldRightIndexed(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfT);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramArrayOfT[i], paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull short[] paramArrayOfShort, R paramR, @NotNull Function3<? super Integer, ? super Short, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Short.valueOf(paramArrayOfShort[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull boolean[] paramArrayOfBoolean, R paramR, @NotNull Function3<? super Integer, ? super Boolean, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = ArraysKt.getLastIndex(paramArrayOfBoolean);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Boolean.valueOf(paramArrayOfBoolean[i]), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final void forEach(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  public static final <T> void forEach(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(paramArrayOfT[i]);
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
  }
  
  public static final void forEach(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Integer, ? super Byte, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      byte b = paramArrayOfByte[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Byte.valueOf(b));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Integer, ? super Character, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      char c = paramArrayOfChar[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Integer, ? super Double, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      double d = paramArrayOfDouble[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Double.valueOf(d));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Integer, ? super Float, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      float f = paramArrayOfFloat[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Float.valueOf(f));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfInt[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Integer.valueOf(n));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Integer, ? super Long, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      long l = paramArrayOfLong[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Long.valueOf(l));
      j += 1;
    }
  }
  
  public static final <T> void forEachIndexed(@NotNull T[] paramArrayOfT, @NotNull Function2<? super Integer, ? super T, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      T ? = paramArrayOfT[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), ?);
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Integer, ? super Short, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      short s = paramArrayOfShort[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Short.valueOf(s));
      j += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Integer, ? super Boolean, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int m = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfBoolean[j];
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Boolean.valueOf(n));
      j += 1;
    }
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfByte));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfChar));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfDouble));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfFloat));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfInt));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfLong));
  }
  
  @NotNull
  public static final <T> IntRange getIndices(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfT));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfShort));
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$indices");
    return new IntRange(0, ArraysKt.getLastIndex(paramArrayOfBoolean));
  }
  
  public static final int getLastIndex(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastIndex");
    return paramArrayOfByte.length - 1;
  }
  
  public static final int getLastIndex(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$lastIndex");
    return paramArrayOfChar.length - 1;
  }
  
  public static final int getLastIndex(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$lastIndex");
    return paramArrayOfDouble.length - 1;
  }
  
  public static final int getLastIndex(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$lastIndex");
    return paramArrayOfFloat.length - 1;
  }
  
  public static final int getLastIndex(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastIndex");
    return paramArrayOfInt.length - 1;
  }
  
  public static final int getLastIndex(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastIndex");
    return paramArrayOfLong.length - 1;
  }
  
  public static final <T> int getLastIndex(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$lastIndex");
    return paramArrayOfT.length - 1;
  }
  
  public static final int getLastIndex(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastIndex");
    return paramArrayOfShort.length - 1;
  }
  
  public static final int getLastIndex(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$lastIndex");
    return paramArrayOfBoolean.length - 1;
  }
  
  @InlineOnly
  private static final byte getOrElse(@NotNull byte[] paramArrayOfByte, int paramInt, Function1<? super Integer, Byte> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return paramArrayOfByte[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).byteValue();
  }
  
  @InlineOnly
  private static final char getOrElse(@NotNull char[] paramArrayOfChar, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfChar))) {
      return paramArrayOfChar[paramInt];
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  @InlineOnly
  private static final double getOrElse(@NotNull double[] paramArrayOfDouble, int paramInt, Function1<? super Integer, Double> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfDouble))) {
      return paramArrayOfDouble[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).doubleValue();
  }
  
  @InlineOnly
  private static final float getOrElse(@NotNull float[] paramArrayOfFloat, int paramInt, Function1<? super Integer, Float> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfFloat))) {
      return paramArrayOfFloat[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).floatValue();
  }
  
  @InlineOnly
  private static final int getOrElse(@NotNull int[] paramArrayOfInt, int paramInt, Function1<? super Integer, Integer> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return paramArrayOfInt[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).intValue();
  }
  
  @InlineOnly
  private static final long getOrElse(@NotNull long[] paramArrayOfLong, int paramInt, Function1<? super Integer, Long> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return paramArrayOfLong[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).longValue();
  }
  
  @InlineOnly
  private static final <T> T getOrElse(@NotNull T[] paramArrayOfT, int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfT))) {
      return paramArrayOfT[paramInt];
    }
    return paramFunction1.invoke(Integer.valueOf(paramInt));
  }
  
  @InlineOnly
  private static final short getOrElse(@NotNull short[] paramArrayOfShort, int paramInt, Function1<? super Integer, Short> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return paramArrayOfShort[paramInt];
    }
    return ((Number)paramFunction1.invoke(Integer.valueOf(paramInt))).shortValue();
  }
  
  @InlineOnly
  private static final boolean getOrElse(@NotNull boolean[] paramArrayOfBoolean, int paramInt, Function1<? super Integer, Boolean> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfBoolean))) {
      return paramArrayOfBoolean[paramInt];
    }
    return ((Boolean)paramFunction1.invoke(Integer.valueOf(paramInt))).booleanValue();
  }
  
  @Nullable
  public static final Boolean getOrNull(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfBoolean))) {
      return Boolean.valueOf(paramArrayOfBoolean[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Byte getOrNull(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return Byte.valueOf(paramArrayOfByte[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Character getOrNull(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfChar))) {
      return Character.valueOf(paramArrayOfChar[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Double getOrNull(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfDouble))) {
      return Double.valueOf(paramArrayOfDouble[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Float getOrNull(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfFloat))) {
      return Float.valueOf(paramArrayOfFloat[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Integer getOrNull(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return Integer.valueOf(paramArrayOfInt[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final Long getOrNull(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return Long.valueOf(paramArrayOfLong[paramInt]);
    }
    return null;
  }
  
  @Nullable
  public static final <T> T getOrNull(@NotNull T[] paramArrayOfT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfT))) {
      return paramArrayOfT[paramInt];
    }
    return null;
  }
  
  @Nullable
  public static final Short getOrNull(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return Short.valueOf(paramArrayOfShort[paramInt]);
    }
    return null;
  }
  
  @NotNull
  public static final <K> Map<K, List<Byte>> groupBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(Byte.valueOf(b));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Byte.valueOf(b));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends K> paramFunction1, @NotNull Function1<? super Byte, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(Byte.valueOf(b));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Byte.valueOf(b)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Character>> groupBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c = paramArrayOfChar[i];
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Character.valueOf(c));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c = paramArrayOfChar[i];
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Double>> groupBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfDouble.length;
    int i = 0;
    if (i < j)
    {
      double d = paramArrayOfDouble[i];
      Object localObject2 = paramFunction1.invoke(Double.valueOf(d));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Double.valueOf(d));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends K> paramFunction1, @NotNull Function1<? super Double, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfDouble.length;
    int i = 0;
    if (i < j)
    {
      double d = paramArrayOfDouble[i];
      Object localObject2 = paramFunction1.invoke(Double.valueOf(d));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Double.valueOf(d)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Float>> groupBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < j)
    {
      float f = paramArrayOfFloat[i];
      Object localObject2 = paramFunction1.invoke(Float.valueOf(f));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Float.valueOf(f));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends K> paramFunction1, @NotNull Function1<? super Float, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < j)
    {
      float f = paramArrayOfFloat[i];
      Object localObject2 = paramFunction1.invoke(Float.valueOf(f));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Float.valueOf(f)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Integer>> groupBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(Integer.valueOf(k));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Integer.valueOf(k));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends K> paramFunction1, @NotNull Function1<? super Integer, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(Integer.valueOf(k));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Integer.valueOf(k)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Long>> groupBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(Long.valueOf(l));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Long.valueOf(l));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends K> paramFunction1, @NotNull Function1<? super Long, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(Long.valueOf(l));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Long.valueOf(l)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K> Map<K, List<T>> groupBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      T ? = paramArrayOfT[i];
      Object localObject2 = paramFunction1.invoke(?);
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(?);
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      T ? = paramArrayOfT[i];
      Object localObject2 = paramFunction1.invoke(?);
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(?));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Short>> groupBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(Short.valueOf(s));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Short.valueOf(s));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends K> paramFunction1, @NotNull Function1<? super Short, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(Short.valueOf(s));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Short.valueOf(s)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, List<Boolean>> groupBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfBoolean[i];
      Object localObject2 = paramFunction1.invoke(Boolean.valueOf(k));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Boolean.valueOf(k));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends K> paramFunction1, @NotNull Function1<? super Boolean, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfBoolean[i];
      Object localObject2 = paramFunction1.invoke(Boolean.valueOf(k));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Boolean.valueOf(k)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(@NotNull byte[] paramArrayOfByte, @NotNull M paramM, @NotNull Function1<? super Byte, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(Byte.valueOf(b));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Byte.valueOf(b));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull byte[] paramArrayOfByte, @NotNull M paramM, @NotNull Function1<? super Byte, ? extends K> paramFunction1, @NotNull Function1<? super Byte, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(Byte.valueOf(b));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Byte.valueOf(b)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull char[] paramArrayOfChar, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c = paramArrayOfChar[i];
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Character.valueOf(c));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull char[] paramArrayOfChar, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c = paramArrayOfChar[i];
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(@NotNull double[] paramArrayOfDouble, @NotNull M paramM, @NotNull Function1<? super Double, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfDouble.length;
    int i = 0;
    if (i < j)
    {
      double d = paramArrayOfDouble[i];
      Object localObject2 = paramFunction1.invoke(Double.valueOf(d));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Double.valueOf(d));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull double[] paramArrayOfDouble, @NotNull M paramM, @NotNull Function1<? super Double, ? extends K> paramFunction1, @NotNull Function1<? super Double, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfDouble.length;
    int i = 0;
    if (i < j)
    {
      double d = paramArrayOfDouble[i];
      Object localObject2 = paramFunction1.invoke(Double.valueOf(d));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Double.valueOf(d)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(@NotNull float[] paramArrayOfFloat, @NotNull M paramM, @NotNull Function1<? super Float, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < j)
    {
      float f = paramArrayOfFloat[i];
      Object localObject2 = paramFunction1.invoke(Float.valueOf(f));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Float.valueOf(f));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull float[] paramArrayOfFloat, @NotNull M paramM, @NotNull Function1<? super Float, ? extends K> paramFunction1, @NotNull Function1<? super Float, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < j)
    {
      float f = paramArrayOfFloat[i];
      Object localObject2 = paramFunction1.invoke(Float.valueOf(f));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Float.valueOf(f)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(@NotNull int[] paramArrayOfInt, @NotNull M paramM, @NotNull Function1<? super Integer, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(Integer.valueOf(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Integer.valueOf(k));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull int[] paramArrayOfInt, @NotNull M paramM, @NotNull Function1<? super Integer, ? extends K> paramFunction1, @NotNull Function1<? super Integer, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(Integer.valueOf(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Integer.valueOf(k)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(@NotNull long[] paramArrayOfLong, @NotNull M paramM, @NotNull Function1<? super Long, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(Long.valueOf(l));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Long.valueOf(l));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull long[] paramArrayOfLong, @NotNull M paramM, @NotNull Function1<? super Long, ? extends K> paramFunction1, @NotNull Function1<? super Long, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(Long.valueOf(l));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Long.valueOf(l)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull T[] paramArrayOfT, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      T ? = paramArrayOfT[i];
      Object localObject2 = paramFunction1.invoke(?);
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(?);
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull T[] paramArrayOfT, @NotNull M paramM, @NotNull Function1<? super T, ? extends K> paramFunction1, @NotNull Function1<? super T, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      T ? = paramArrayOfT[i];
      Object localObject2 = paramFunction1.invoke(?);
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(?));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(@NotNull short[] paramArrayOfShort, @NotNull M paramM, @NotNull Function1<? super Short, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(Short.valueOf(s));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Short.valueOf(s));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull short[] paramArrayOfShort, @NotNull M paramM, @NotNull Function1<? super Short, ? extends K> paramFunction1, @NotNull Function1<? super Short, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(Short.valueOf(s));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Short.valueOf(s)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull M paramM, @NotNull Function1<? super Boolean, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfBoolean[i];
      Object localObject2 = paramFunction1.invoke(Boolean.valueOf(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Boolean.valueOf(k));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull M paramM, @NotNull Function1<? super Boolean, ? extends K> paramFunction1, @NotNull Function1<? super Boolean, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfBoolean[i];
      Object localObject2 = paramFunction1.invoke(Boolean.valueOf(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Boolean.valueOf(k)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K> Grouping<T, K> groupingBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    return (Grouping)new ArraysKt___ArraysKt.groupingBy.1(paramArrayOfT, paramFunction1);
  }
  
  public static final int indexOf(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      if (paramByte == paramArrayOfByte[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull char[] paramArrayOfChar, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      if (paramChar == paramArrayOfChar[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull double[] paramArrayOfDouble, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfDouble.length;
    while (i < j)
    {
      if (paramDouble == paramArrayOfDouble[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull float[] paramArrayOfFloat, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      if (paramFloat == paramArrayOfFloat[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (paramInt == paramArrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      if (paramLong == paramArrayOfLong[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOf(@NotNull T[] paramArrayOfT, T paramT)
  {
    int j = 0;
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$indexOf");
    if (paramT == null)
    {
      j = paramArrayOfT.length;
      while (i < j)
      {
        if (paramArrayOfT[i] == null)
        {
          j = i;
          return j;
        }
        i += 1;
      }
    }
    int k = paramArrayOfT.length;
    i = j;
    for (;;)
    {
      if (i >= k) {
        break label71;
      }
      j = i;
      if (Intrinsics.areEqual(paramT, paramArrayOfT[i])) {
        break;
      }
      i += 1;
    }
    label71:
    return -1;
  }
  
  public static final int indexOf(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      if (paramShort == paramArrayOfShort[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOf(@NotNull boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfBoolean.length;
    while (i < j)
    {
      if (paramBoolean == paramArrayOfBoolean[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfDouble.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfFirst(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfFirst(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramArrayOfBoolean.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfDouble.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfFloat.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final <T> int indexOfLast(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfT.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfBoolean.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @NotNull
  public static final Set<Byte> intersect(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<Byte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfByte = ArraysKt.toMutableSet(paramArrayOfByte);
    CollectionsKt.retainAll((Collection)paramArrayOfByte, paramIterable);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final Set<Character> intersect(@NotNull char[] paramArrayOfChar, @NotNull Iterable<Character> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfChar = ArraysKt.toMutableSet(paramArrayOfChar);
    CollectionsKt.retainAll((Collection)paramArrayOfChar, paramIterable);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final Set<Double> intersect(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfDouble = ArraysKt.toMutableSet(paramArrayOfDouble);
    CollectionsKt.retainAll((Collection)paramArrayOfDouble, paramIterable);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final Set<Float> intersect(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfFloat = ArraysKt.toMutableSet(paramArrayOfFloat);
    CollectionsKt.retainAll((Collection)paramArrayOfFloat, paramIterable);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final Set<Integer> intersect(@NotNull int[] paramArrayOfInt, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfInt = ArraysKt.toMutableSet(paramArrayOfInt);
    CollectionsKt.retainAll((Collection)paramArrayOfInt, paramIterable);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final Set<Long> intersect(@NotNull long[] paramArrayOfLong, @NotNull Iterable<Long> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfLong = ArraysKt.toMutableSet(paramArrayOfLong);
    CollectionsKt.retainAll((Collection)paramArrayOfLong, paramIterable);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T> Set<T> intersect(@NotNull T[] paramArrayOfT, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfT = ArraysKt.toMutableSet(paramArrayOfT);
    CollectionsKt.retainAll((Collection)paramArrayOfT, paramIterable);
    return paramArrayOfT;
  }
  
  @NotNull
  public static final Set<Short> intersect(@NotNull short[] paramArrayOfShort, @NotNull Iterable<Short> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfShort = ArraysKt.toMutableSet(paramArrayOfShort);
    CollectionsKt.retainAll((Collection)paramArrayOfShort, paramIterable);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final Set<Boolean> intersect(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<Boolean> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$intersect");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfBoolean = ArraysKt.toMutableSet(paramArrayOfBoolean);
    CollectionsKt.retainAll((Collection)paramArrayOfBoolean, paramIterable);
    return paramArrayOfBoolean;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull char[] paramArrayOfChar)
  {
    return paramArrayOfChar.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull double[] paramArrayOfDouble)
  {
    return paramArrayOfDouble.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull long[] paramArrayOfLong)
  {
    return paramArrayOfLong.length == 0;
  }
  
  @InlineOnly
  private static final <T> boolean isEmpty(@NotNull T[] paramArrayOfT)
  {
    return paramArrayOfT.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull short[] paramArrayOfShort)
  {
    return paramArrayOfShort.length == 0;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull boolean[] paramArrayOfBoolean)
  {
    return paramArrayOfBoolean.length == 0;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull char[] paramArrayOfChar)
  {
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final <T> boolean isNotEmpty(@NotNull T[] paramArrayOfT)
  {
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull short[] paramArrayOfShort)
  {
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull byte[] paramArrayOfByte, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfByte.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      byte b = paramArrayOfByte[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Byte.valueOf(b)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(b));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull char[] paramArrayOfChar, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Character, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfChar.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      char c = paramArrayOfChar[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Character.valueOf(c)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append(c);
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull double[] paramArrayOfDouble, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Double, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfDouble.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      double d = paramArrayOfDouble[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Double.valueOf(d)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(d));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull float[] paramArrayOfFloat, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Float, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfFloat.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      float f = paramArrayOfFloat[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Float.valueOf(f)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(f));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull int[] paramArrayOfInt, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfInt.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      k = paramArrayOfInt[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Integer.valueOf(k)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(k));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull long[] paramArrayOfLong, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Long, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfLong.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      long l = paramArrayOfLong[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Long.valueOf(l)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(l));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <T, A extends Appendable> A joinTo(@NotNull T[] paramArrayOfT, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfT.length;
    int j = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      paramCharSequence2 = paramArrayOfT[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        k = i;
        if (i > paramInt) {
          break;
        }
      }
      StringsKt.appendElement(paramA, paramCharSequence2, paramFunction1);
      j += 1;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull short[] paramArrayOfShort, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Short, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfShort.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      short s = paramArrayOfShort[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Short.valueOf(s)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(s));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final <A extends Appendable> A joinTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull A paramA, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$joinTo");
    Intrinsics.checkParameterIsNotNull(paramA, "buffer");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfBoolean.length;
    int j = 0;
    int k = i;
    if (j < m)
    {
      int n = paramArrayOfBoolean[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if ((paramInt < 0) || (i <= paramInt))
      {
        if (paramFunction1 != null) {
          paramA.append((CharSequence)paramFunction1.invoke(Boolean.valueOf(n)));
        }
        for (;;)
        {
          j += 1;
          break;
          paramA.append((CharSequence)String.valueOf(n));
        }
      }
      k = i;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  @NotNull
  public static final String joinToString(@NotNull byte[] paramArrayOfByte, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfByte = ((StringBuilder)ArraysKt.joinTo(paramArrayOfByte, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final String joinToString(@NotNull char[] paramArrayOfChar, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Character, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfChar = ((StringBuilder)ArraysKt.joinTo(paramArrayOfChar, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final String joinToString(@NotNull double[] paramArrayOfDouble, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Double, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfDouble = ((StringBuilder)ArraysKt.joinTo(paramArrayOfDouble, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final String joinToString(@NotNull float[] paramArrayOfFloat, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Float, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfFloat = ((StringBuilder)ArraysKt.joinTo(paramArrayOfFloat, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final String joinToString(@NotNull int[] paramArrayOfInt, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfInt = ((StringBuilder)ArraysKt.joinTo(paramArrayOfInt, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final String joinToString(@NotNull long[] paramArrayOfLong, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Long, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfLong = ((StringBuilder)ArraysKt.joinTo(paramArrayOfLong, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T> String joinToString(@NotNull T[] paramArrayOfT, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfT = ((StringBuilder)ArraysKt.joinTo(paramArrayOfT, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfT;
  }
  
  @NotNull
  public static final String joinToString(@NotNull short[] paramArrayOfShort, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Short, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfShort = ((StringBuilder)ArraysKt.joinTo(paramArrayOfShort, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final String joinToString(@NotNull boolean[] paramArrayOfBoolean, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3, int paramInt, @NotNull CharSequence paramCharSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$joinToString");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "separator");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "postfix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence4, "truncated");
    paramArrayOfBoolean = ((StringBuilder)ArraysKt.joinTo(paramArrayOfBoolean, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramFunction1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfBoolean;
  }
  
  public static final byte last(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$last");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfByte[ArraysKt.getLastIndex(paramArrayOfByte)];
  }
  
  public static final byte last(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return b;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final char last(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$last");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfChar[ArraysKt.getLastIndex(paramArrayOfChar)];
  }
  
  public static final char last(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return c;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final double last(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$last");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfDouble[ArraysKt.getLastIndex(paramArrayOfDouble)];
  }
  
  public static final double last(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfDouble.length - 1;
    while (i >= 0)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return d;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final float last(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$last");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfFloat[ArraysKt.getLastIndex(paramArrayOfFloat)];
  }
  
  public static final float last(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfFloat.length - 1;
    while (i >= 0)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return f;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final int last(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$last");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfInt[ArraysKt.getLastIndex(paramArrayOfInt)];
  }
  
  public static final int last(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(j))).booleanValue()) {
        return j;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final long last(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$last");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfLong[ArraysKt.getLastIndex(paramArrayOfLong)];
  }
  
  public static final long last(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return l;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final <T> T last(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$last");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfT[ArraysKt.getLastIndex(paramArrayOfT)];
  }
  
  public static final <T> T last(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfT.length - 1;
    while (i >= 0)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final short last(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$last");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfShort[ArraysKt.getLastIndex(paramArrayOfShort)];
  }
  
  public static final short last(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return s;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final boolean last(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$last");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfBoolean[ArraysKt.getLastIndex(paramArrayOfBoolean)];
  }
  
  public static final boolean last(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfBoolean.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(j))).booleanValue()) {
        return j;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  public static final int lastIndexOf(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastIndexOf");
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      if (paramByte == paramArrayOfByte[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull char[] paramArrayOfChar, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$lastIndexOf");
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      if (paramChar == paramArrayOfChar[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull double[] paramArrayOfDouble, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$lastIndexOf");
    int i = paramArrayOfDouble.length - 1;
    while (i >= 0)
    {
      if (paramDouble == paramArrayOfDouble[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull float[] paramArrayOfFloat, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$lastIndexOf");
    int i = paramArrayOfFloat.length - 1;
    while (i >= 0)
    {
      if (paramFloat == paramArrayOfFloat[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastIndexOf");
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      if (paramInt == paramArrayOfInt[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastIndexOf");
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      if (paramLong == paramArrayOfLong[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final <T> int lastIndexOf(@NotNull T[] paramArrayOfT, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$lastIndexOf");
    int j;
    if (paramT == null)
    {
      i = paramArrayOfT.length - 1;
      while (i >= 0)
      {
        if (paramArrayOfT[i] == null)
        {
          j = i;
          return j;
        }
        i -= 1;
      }
    }
    int i = paramArrayOfT.length - 1;
    for (;;)
    {
      if (i < 0) {
        break label65;
      }
      j = i;
      if (Intrinsics.areEqual(paramT, paramArrayOfT[i])) {
        break;
      }
      i -= 1;
    }
    label65:
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastIndexOf");
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      if (paramShort == paramArrayOfShort[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final int lastIndexOf(@NotNull boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$lastIndexOf");
    int i = paramArrayOfBoolean.length - 1;
    while (i >= 0)
    {
      if (paramBoolean == paramArrayOfBoolean[i]) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @Nullable
  public static final Boolean lastOrNull(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$lastOrNull");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Boolean.valueOf(paramArrayOfBoolean[(paramArrayOfBoolean.length - 1)]);
  }
  
  @Nullable
  public static final Boolean lastOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfBoolean.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(j))).booleanValue()) {
        return Boolean.valueOf(j);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Byte lastOrNull(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastOrNull");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Byte.valueOf(paramArrayOfByte[(paramArrayOfByte.length - 1)]);
  }
  
  @Nullable
  public static final Byte lastOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        return Byte.valueOf(b);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Character lastOrNull(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$lastOrNull");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramArrayOfChar[(paramArrayOfChar.length - 1)]);
  }
  
  @Nullable
  public static final Character lastOrNull(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Double lastOrNull(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$lastOrNull");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Double.valueOf(paramArrayOfDouble[(paramArrayOfDouble.length - 1)]);
  }
  
  @Nullable
  public static final Double lastOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfDouble.length - 1;
    while (i >= 0)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        return Double.valueOf(d);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Float lastOrNull(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$lastOrNull");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Float.valueOf(paramArrayOfFloat[(paramArrayOfFloat.length - 1)]);
  }
  
  @Nullable
  public static final Float lastOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfFloat.length - 1;
    while (i >= 0)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        return Float.valueOf(f);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Integer lastOrNull(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastOrNull");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Integer.valueOf(paramArrayOfInt[(paramArrayOfInt.length - 1)]);
  }
  
  @Nullable
  public static final Integer lastOrNull(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      int j = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(j))).booleanValue()) {
        return Integer.valueOf(j);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Long lastOrNull(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastOrNull");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Long.valueOf(paramArrayOfLong[(paramArrayOfLong.length - 1)]);
  }
  
  @Nullable
  public static final Long lastOrNull(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        return Long.valueOf(l);
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$lastOrNull");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return paramArrayOfT[(paramArrayOfT.length - 1)];
  }
  
  @Nullable
  public static final <T> T lastOrNull(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfT.length - 1;
    while (i >= 0)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        return ?;
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public static final Short lastOrNull(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastOrNull");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Short.valueOf(paramArrayOfShort[(paramArrayOfShort.length - 1)]);
  }
  
  @Nullable
  public static final Short lastOrNull(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        return Short.valueOf(s);
      }
      i -= 1;
    }
    return null;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfChar.length);
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfDouble.length);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfFloat.length);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfInt.length);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> map(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfT.length);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(paramArrayOfT[i]));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfShort.length);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfBoolean.length);
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Integer, ? super Byte, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfByte.length);
    int m = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      byte b = paramArrayOfByte[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Byte.valueOf(b)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfChar.length);
    int m = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      char c = paramArrayOfChar[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Integer, ? super Double, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfDouble.length);
    int m = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      double d = paramArrayOfDouble[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Double.valueOf(d)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Integer, ? super Float, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfFloat.length);
    int m = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      float f = paramArrayOfFloat[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Float.valueOf(f)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfInt.length);
    int m = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfInt[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Integer.valueOf(n)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Integer, ? super Long, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfLong.length);
    int m = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      long l = paramArrayOfLong[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Long.valueOf(l)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> mapIndexed(@NotNull T[] paramArrayOfT, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfT.length);
    int m = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      T ? = paramArrayOfT[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), ?));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Integer, ? super Short, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfShort.length);
    int m = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      short s = paramArrayOfShort[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Short.valueOf(s)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfBoolean.length);
    int m = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfBoolean[j];
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Boolean.valueOf(n)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R> List<R> mapIndexedNotNull(@NotNull T[] paramArrayOfT, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfT.length;
    int i = 0;
    while (j < k)
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), paramArrayOfT[j]);
      if (localObject != null) {
        localCollection.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int k = paramArrayOfT.length;
    int i = 0;
    while (j < k)
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), paramArrayOfT[j]);
      if (localObject != null) {
        paramC.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Byte, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      byte b = paramArrayOfByte[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Byte.valueOf(b)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      char c = paramArrayOfChar[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Double, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      double d = paramArrayOfDouble[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Double.valueOf(d)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Float, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      float f = paramArrayOfFloat[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Float.valueOf(f)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Integer, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfInt[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Integer.valueOf(n)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Long, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      long l = paramArrayOfLong[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Long.valueOf(l)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function2<? super Integer, ? super T, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      T ? = paramArrayOfT[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), ?));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Short, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      short s = paramArrayOfShort[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Short.valueOf(s)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int m = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= m) {
        break;
      }
      int n = paramArrayOfBoolean[j];
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Boolean.valueOf(n)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R> List<R> mapNotNull(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramFunction1.invoke(paramArrayOfT[i]);
      if (localObject != null) {
        localCollection.add(localObject);
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramFunction1.invoke(paramArrayOfT[i]);
      if (localObject != null) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull byte[] paramArrayOfByte, @NotNull C paramC, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull char[] paramArrayOfChar, @NotNull C paramC, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull double[] paramArrayOfDouble, @NotNull C paramC, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull float[] paramArrayOfFloat, @NotNull C paramC, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull int[] paramArrayOfInt, @NotNull C paramC, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull long[] paramArrayOfLong, @NotNull C paramC, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull T[] paramArrayOfT, @NotNull C paramC, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(paramArrayOfT[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull short[] paramArrayOfShort, @NotNull C paramC, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i])));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i])));
      i += 1;
    }
    return paramC;
  }
  
  @Nullable
  public static final Byte max(@NotNull byte[] paramArrayOfByte)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$max");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= k)
    {
      b2 = b1;
      i = j;
      for (;;)
      {
        byte b3 = paramArrayOfByte[i];
        b1 = b2;
        if (b2 < b3) {
          b1 = b3;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        b2 = b1;
      }
    }
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final Character max(@NotNull char[] paramArrayOfChar)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$max");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramArrayOfChar[i];
        c1 = c2;
        if (c2 < c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T max(@NotNull T[] paramArrayOfT)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$max");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label31;
      }
      localObject2 = null;
    }
    label31:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (1 > k);
    Object localObject2 = localObject1;
    int i = j;
    for (;;)
    {
      T ? = paramArrayOfT[i];
      localObject1 = localObject2;
      if (((Comparable)localObject2).compareTo(?) < 0) {
        localObject1 = ?;
      }
      localObject2 = localObject1;
      if (i == k) {
        break;
      }
      i += 1;
      localObject2 = localObject1;
    }
  }
  
  @Nullable
  public static final Double max(@NotNull double[] paramArrayOfDouble)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$max");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    if (Double.isNaN(d1)) {
      return Double.valueOf(d1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i];
        if (Double.isNaN(d3)) {
          return Double.valueOf(d3);
        }
        d1 = d2;
        if (d2 < d3) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double max(@NotNull Double[] paramArrayOfDouble)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$max");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0].doubleValue();
    if (Double.isNaN(d1)) {
      return Double.valueOf(d1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i].doubleValue();
        if (Double.isNaN(d3)) {
          return Double.valueOf(d3);
        }
        d1 = d2;
        if (d2 < d3) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final Float max(@NotNull float[] paramArrayOfFloat)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$max");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    if (Float.isNaN(f1)) {
      return Float.valueOf(f1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i];
        if (Float.isNaN(f3)) {
          return Float.valueOf(f3);
        }
        f1 = f2;
        if (f2 < f3) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Float max(@NotNull Float[] paramArrayOfFloat)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$max");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0].floatValue();
    if (Float.isNaN(f1)) {
      return Float.valueOf(f1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i].floatValue();
        if (Float.isNaN(f3)) {
          return Float.valueOf(f3);
        }
        f1 = f2;
        if (f2 < f3) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final Integer max(@NotNull int[] paramArrayOfInt)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$max");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = paramArrayOfInt[j];
        i = k;
        if (k < m) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final Long max(@NotNull long[] paramArrayOfLong)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$max");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= k)
    {
      l2 = l1;
      i = j;
      for (;;)
      {
        long l3 = paramArrayOfLong[i];
        l1 = l2;
        if (l2 < l3) {
          l1 = l3;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        l2 = l1;
      }
    }
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final Short max(@NotNull short[] paramArrayOfShort)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$max");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= k)
    {
      s2 = s1;
      i = j;
      for (;;)
      {
        short s3 = paramArrayOfShort[i];
        s1 = s2;
        if (s2 < s3) {
          s1 = s3;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        s2 = s1;
      }
    }
    return Short.valueOf(s2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Boolean maxBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int m = paramArrayOfBoolean[0];
    int k = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (k == 0) {
      return Boolean.valueOf(m);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Boolean.valueOf(m));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        n = paramArrayOfBoolean[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Boolean.valueOf(n));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          m = n;
        }
        n = m;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    int n = m;
    return Boolean.valueOf(n);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Byte maxBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    if (k == 0) {
      return Byte.valueOf(b1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Byte.valueOf(b1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        b2 = paramArrayOfByte[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Byte.valueOf(b2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          b1 = b2;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    byte b2 = b1;
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Character maxBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramArrayOfChar[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          c1 = c2;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Double maxBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (k == 0) {
      return Double.valueOf(d1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Double.valueOf(d1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        d2 = paramArrayOfDouble[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Double.valueOf(d2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          d1 = d2;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    double d2 = d1;
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Float maxBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (k == 0) {
      return Float.valueOf(f1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Float.valueOf(f1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        f2 = paramArrayOfFloat[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Float.valueOf(f2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          f1 = f2;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    float f2 = f1;
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Integer maxBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (m == 0) {
      return Integer.valueOf(i);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Integer.valueOf(i));
    if (1 <= m) {
      for (;;)
      {
        k = paramArrayOfInt[j];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Integer.valueOf(k));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          i = k;
        }
        k = i;
        if (j == m) {
          break;
        }
        j += 1;
        localObject1 = localObject2;
      }
    }
    int k = i;
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Long maxBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    if (k == 0) {
      return Long.valueOf(l1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Long.valueOf(l1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        l2 = paramArrayOfLong[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Long.valueOf(l2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          l1 = l2;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    long l2 = l1;
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i;
    Object localObject2;
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      localObject2 = null;
    }
    label38:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (k == 0);
    Object localObject3 = (Comparable)paramFunction1.invoke(localObject1);
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        T ? = paramArrayOfT[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(?);
        localObject2 = localObject3;
        if (((Comparable)localObject3).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          localObject1 = ?;
        }
        localObject3 = localObject1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject3 = localObject2;
      }
    }
    localObject3 = localObject1;
    return localObject3;
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Short maxBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    if (k == 0) {
      return Short.valueOf(s1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Short.valueOf(s1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        s2 = paramArrayOfShort[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Short.valueOf(s2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          s1 = s2;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    short s2 = s1;
    return Short.valueOf(s2);
  }
  
  @Nullable
  public static final Boolean maxWith(@NotNull boolean[] paramArrayOfBoolean, @NotNull Comparator<? super Boolean> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int m = paramArrayOfBoolean[0];
    int k = ArraysKt.getLastIndex(paramArrayOfBoolean);
    int n = m;
    if (1 <= k)
    {
      n = m;
      i = j;
      for (;;)
      {
        int i1 = paramArrayOfBoolean[i];
        m = n;
        if (paramComparator.compare(Boolean.valueOf(n), Boolean.valueOf(i1)) < 0) {
          m = i1;
        }
        n = m;
        if (i == k) {
          break;
        }
        i += 1;
        n = m;
      }
    }
    return Boolean.valueOf(n);
  }
  
  @Nullable
  public static final Byte maxWith(@NotNull byte[] paramArrayOfByte, @NotNull Comparator<? super Byte> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= k)
    {
      b2 = b1;
      i = j;
      for (;;)
      {
        byte b3 = paramArrayOfByte[i];
        b1 = b2;
        if (paramComparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) < 0) {
          b1 = b3;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        b2 = b1;
      }
    }
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final Character maxWith(@NotNull char[] paramArrayOfChar, @NotNull Comparator<? super Character> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramArrayOfChar[i];
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final Double maxWith(@NotNull double[] paramArrayOfDouble, @NotNull Comparator<? super Double> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i];
        d1 = d2;
        if (paramComparator.compare(Double.valueOf(d2), Double.valueOf(d3)) < 0) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final Float maxWith(@NotNull float[] paramArrayOfFloat, @NotNull Comparator<? super Float> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i];
        f1 = f2;
        if (paramComparator.compare(Float.valueOf(f2), Float.valueOf(f3)) < 0) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final Integer maxWith(@NotNull int[] paramArrayOfInt, @NotNull Comparator<? super Integer> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = paramArrayOfInt[j];
        i = k;
        if (paramComparator.compare(Integer.valueOf(k), Integer.valueOf(m)) < 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final Long maxWith(@NotNull long[] paramArrayOfLong, @NotNull Comparator<? super Long> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= k)
    {
      l2 = l1;
      i = j;
      for (;;)
      {
        long l3 = paramArrayOfLong[i];
        l1 = l2;
        if (paramComparator.compare(Long.valueOf(l2), Long.valueOf(l3)) < 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        l2 = l1;
      }
    }
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final <T> T maxWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      localObject2 = null;
    }
    label38:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (1 > k);
    Object localObject2 = localObject1;
    int i = j;
    for (;;)
    {
      T ? = paramArrayOfT[i];
      localObject1 = localObject2;
      if (paramComparator.compare(localObject2, ?) < 0) {
        localObject1 = ?;
      }
      localObject2 = localObject1;
      if (i == k) {
        break;
      }
      i += 1;
      localObject2 = localObject1;
    }
  }
  
  @Nullable
  public static final Short maxWith(@NotNull short[] paramArrayOfShort, @NotNull Comparator<? super Short> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= k)
    {
      s2 = s1;
      i = j;
      for (;;)
      {
        short s3 = paramArrayOfShort[i];
        s1 = s2;
        if (paramComparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
          s1 = s3;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        s2 = s1;
      }
    }
    return Short.valueOf(s2);
  }
  
  @Nullable
  public static final Byte min(@NotNull byte[] paramArrayOfByte)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$min");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= k)
    {
      b2 = b1;
      i = j;
      for (;;)
      {
        byte b3 = paramArrayOfByte[i];
        b1 = b2;
        if (b2 > b3) {
          b1 = b3;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        b2 = b1;
      }
    }
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final Character min(@NotNull char[] paramArrayOfChar)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$min");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramArrayOfChar[i];
        c1 = c2;
        if (c2 > c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <T extends Comparable<? super T>> T min(@NotNull T[] paramArrayOfT)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$min");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label31;
      }
      localObject2 = null;
    }
    label31:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (1 > k);
    Object localObject2 = localObject1;
    int i = j;
    for (;;)
    {
      T ? = paramArrayOfT[i];
      localObject1 = localObject2;
      if (((Comparable)localObject2).compareTo(?) > 0) {
        localObject1 = ?;
      }
      localObject2 = localObject1;
      if (i == k) {
        break;
      }
      i += 1;
      localObject2 = localObject1;
    }
  }
  
  @Nullable
  public static final Double min(@NotNull double[] paramArrayOfDouble)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$min");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    if (Double.isNaN(d1)) {
      return Double.valueOf(d1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i];
        if (Double.isNaN(d3)) {
          return Double.valueOf(d3);
        }
        d1 = d2;
        if (d2 > d3) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double min(@NotNull Double[] paramArrayOfDouble)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$min");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0].doubleValue();
    if (Double.isNaN(d1)) {
      return Double.valueOf(d1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i].doubleValue();
        if (Double.isNaN(d3)) {
          return Double.valueOf(d3);
        }
        d1 = d2;
        if (d2 > d3) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final Float min(@NotNull float[] paramArrayOfFloat)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$min");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    if (Float.isNaN(f1)) {
      return Float.valueOf(f1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i];
        if (Float.isNaN(f3)) {
          return Float.valueOf(f3);
        }
        f1 = f2;
        if (f2 > f3) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Float min(@NotNull Float[] paramArrayOfFloat)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$min");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0].floatValue();
    if (Float.isNaN(f1)) {
      return Float.valueOf(f1);
    }
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i].floatValue();
        if (Float.isNaN(f3)) {
          return Float.valueOf(f3);
        }
        f1 = f2;
        if (f2 > f3) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final Integer min(@NotNull int[] paramArrayOfInt)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$min");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = paramArrayOfInt[j];
        i = k;
        if (k > m) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final Long min(@NotNull long[] paramArrayOfLong)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$min");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= k)
    {
      l2 = l1;
      i = j;
      for (;;)
      {
        long l3 = paramArrayOfLong[i];
        l1 = l2;
        if (l2 > l3) {
          l1 = l3;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        l2 = l1;
      }
    }
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final Short min(@NotNull short[] paramArrayOfShort)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$min");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= k)
    {
      s2 = s1;
      i = j;
      for (;;)
      {
        short s3 = paramArrayOfShort[i];
        s1 = s2;
        if (s2 > s3) {
          s1 = s3;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        s2 = s1;
      }
    }
    return Short.valueOf(s2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Boolean minBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int m = paramArrayOfBoolean[0];
    int k = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (k == 0) {
      return Boolean.valueOf(m);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Boolean.valueOf(m));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        n = paramArrayOfBoolean[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Boolean.valueOf(n));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          m = n;
        }
        n = m;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    int n = m;
    return Boolean.valueOf(n);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Byte minBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    if (k == 0) {
      return Byte.valueOf(b1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Byte.valueOf(b1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        b2 = paramArrayOfByte[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Byte.valueOf(b2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          b1 = b2;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    byte b2 = b1;
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Character minBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramArrayOfChar[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          c1 = c2;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Double minBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (k == 0) {
      return Double.valueOf(d1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Double.valueOf(d1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        d2 = paramArrayOfDouble[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Double.valueOf(d2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          d1 = d2;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    double d2 = d1;
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Float minBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (k == 0) {
      return Float.valueOf(f1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Float.valueOf(f1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        f2 = paramArrayOfFloat[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Float.valueOf(f2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          f1 = f2;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    float f2 = f1;
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Integer minBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (m == 0) {
      return Integer.valueOf(i);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Integer.valueOf(i));
    if (1 <= m) {
      for (;;)
      {
        k = paramArrayOfInt[j];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Integer.valueOf(k));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          i = k;
        }
        k = i;
        if (j == m) {
          break;
        }
        j += 1;
        localObject1 = localObject2;
      }
    }
    int k = i;
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Long minBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    if (k == 0) {
      return Long.valueOf(l1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Long.valueOf(l1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        l2 = paramArrayOfLong[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Long.valueOf(l2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          l1 = l2;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    long l2 = l1;
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final <T, R extends Comparable<? super R>> T minBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i;
    Object localObject2;
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      localObject2 = null;
    }
    label38:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (k == 0);
    Object localObject3 = (Comparable)paramFunction1.invoke(localObject1);
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        T ? = paramArrayOfT[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(?);
        localObject2 = localObject3;
        if (((Comparable)localObject3).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          localObject1 = ?;
        }
        localObject3 = localObject1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject3 = localObject2;
      }
    }
    localObject3 = localObject1;
    return localObject3;
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Short minBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    if (k == 0) {
      return Short.valueOf(s1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Short.valueOf(s1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        s2 = paramArrayOfShort[i];
        Comparable localComparable = (Comparable)paramFunction1.invoke(Short.valueOf(s2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          s1 = s2;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    short s2 = s1;
    return Short.valueOf(s2);
  }
  
  @Nullable
  public static final Boolean minWith(@NotNull boolean[] paramArrayOfBoolean, @NotNull Comparator<? super Boolean> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int m = paramArrayOfBoolean[0];
    int k = ArraysKt.getLastIndex(paramArrayOfBoolean);
    int n = m;
    if (1 <= k)
    {
      n = m;
      i = j;
      for (;;)
      {
        int i1 = paramArrayOfBoolean[i];
        m = n;
        if (paramComparator.compare(Boolean.valueOf(n), Boolean.valueOf(i1)) > 0) {
          m = i1;
        }
        n = m;
        if (i == k) {
          break;
        }
        i += 1;
        n = m;
      }
    }
    return Boolean.valueOf(n);
  }
  
  @Nullable
  public static final Byte minWith(@NotNull byte[] paramArrayOfByte, @NotNull Comparator<? super Byte> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= k)
    {
      b2 = b1;
      i = j;
      for (;;)
      {
        byte b3 = paramArrayOfByte[i];
        b1 = b2;
        if (paramComparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) > 0) {
          b1 = b3;
        }
        b2 = b1;
        if (i == k) {
          break;
        }
        i += 1;
        b2 = b1;
      }
    }
    return Byte.valueOf(b2);
  }
  
  @Nullable
  public static final Character minWith(@NotNull char[] paramArrayOfChar, @NotNull Comparator<? super Character> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramArrayOfChar[i];
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final Double minWith(@NotNull double[] paramArrayOfDouble, @NotNull Comparator<? super Double> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d1 = paramArrayOfDouble[0];
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d2 = d1;
    if (1 <= k)
    {
      d2 = d1;
      i = j;
      for (;;)
      {
        double d3 = paramArrayOfDouble[i];
        d1 = d2;
        if (paramComparator.compare(Double.valueOf(d2), Double.valueOf(d3)) > 0) {
          d1 = d3;
        }
        d2 = d1;
        if (i == k) {
          break;
        }
        i += 1;
        d2 = d1;
      }
    }
    return Double.valueOf(d2);
  }
  
  @Nullable
  public static final Float minWith(@NotNull float[] paramArrayOfFloat, @NotNull Comparator<? super Float> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    float f2 = f1;
    if (1 <= k)
    {
      f2 = f1;
      i = j;
      for (;;)
      {
        float f3 = paramArrayOfFloat[i];
        f1 = f2;
        if (paramComparator.compare(Float.valueOf(f2), Float.valueOf(f3)) > 0) {
          f1 = f3;
        }
        f2 = f1;
        if (i == k) {
          break;
        }
        i += 1;
        f2 = f1;
      }
    }
    return Float.valueOf(f2);
  }
  
  @Nullable
  public static final Integer minWith(@NotNull int[] paramArrayOfInt, @NotNull Comparator<? super Integer> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    i = paramArrayOfInt[0];
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = paramArrayOfInt[j];
        i = k;
        if (paramComparator.compare(Integer.valueOf(k), Integer.valueOf(m)) > 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return Integer.valueOf(k);
  }
  
  @Nullable
  public static final Long minWith(@NotNull long[] paramArrayOfLong, @NotNull Comparator<? super Long> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l1 = paramArrayOfLong[0];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= k)
    {
      l2 = l1;
      i = j;
      for (;;)
      {
        long l3 = paramArrayOfLong[i];
        l1 = l2;
        if (paramComparator.compare(Long.valueOf(l2), Long.valueOf(l3)) > 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == k) {
          break;
        }
        i += 1;
        l2 = l1;
      }
    }
    return Long.valueOf(l2);
  }
  
  @Nullable
  public static final <T> T minWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      localObject2 = null;
    }
    label38:
    Object localObject1;
    int k;
    do
    {
      return localObject2;
      i = 0;
      break;
      localObject1 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject2 = localObject1;
    } while (1 > k);
    Object localObject2 = localObject1;
    int i = j;
    for (;;)
    {
      T ? = paramArrayOfT[i];
      localObject1 = localObject2;
      if (paramComparator.compare(localObject2, ?) > 0) {
        localObject1 = ?;
      }
      localObject2 = localObject1;
      if (i == k) {
        break;
      }
      i += 1;
      localObject2 = localObject1;
    }
  }
  
  @Nullable
  public static final Short minWith(@NotNull short[] paramArrayOfShort, @NotNull Comparator<? super Short> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= k)
    {
      s2 = s1;
      i = j;
      for (;;)
      {
        short s3 = paramArrayOfShort[i];
        s1 = s2;
        if (paramComparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
          s1 = s3;
        }
        s2 = s1;
        if (i == k) {
          break;
        }
        i += 1;
        s2 = s1;
      }
    }
    return Short.valueOf(s2);
  }
  
  public static final boolean none(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$none");
    return paramArrayOfByte.length == 0;
  }
  
  public static final boolean none(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$none");
    return paramArrayOfChar.length == 0;
  }
  
  public static final boolean none(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$none");
    return paramArrayOfDouble.length == 0;
  }
  
  public static final boolean none(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$none");
    return paramArrayOfFloat.length == 0;
  }
  
  public static final boolean none(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$none");
    return paramArrayOfInt.length == 0;
  }
  
  public static final boolean none(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$none");
    return paramArrayOfLong.length == 0;
  }
  
  public static final boolean none(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final <T> boolean none(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$none");
    return paramArrayOfT.length == 0;
  }
  
  public static final <T> boolean none(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$none");
    return paramArrayOfShort.length == 0;
  }
  
  public static final boolean none(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean none(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$none");
    return paramArrayOfBoolean.length == 0;
  }
  
  public static final boolean none(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NotNull
  public static final Pair<List<Byte>, List<Byte>> partition(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        localArrayList1.add(Byte.valueOf(b));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Byte.valueOf(b));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Character>, List<Character>> partition(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c = paramArrayOfChar[i];
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localArrayList1.add(Character.valueOf(c));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Character.valueOf(c));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Double>, List<Double>> partition(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    if (i < j)
    {
      double d = paramArrayOfDouble[i];
      if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        localArrayList1.add(Double.valueOf(d));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Double.valueOf(d));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Float>, List<Float>> partition(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < j)
    {
      float f = paramArrayOfFloat[i];
      if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        localArrayList1.add(Float.valueOf(f));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Float.valueOf(f));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Integer>, List<Integer>> partition(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {
        localArrayList1.add(Integer.valueOf(k));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Integer.valueOf(k));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Long>, List<Long>> partition(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        localArrayList1.add(Long.valueOf(l));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Long.valueOf(l));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final <T> Pair<List<T>, List<T>> partition(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      T ? = paramArrayOfT[i];
      if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        localArrayList1.add(?);
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(?);
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Short>, List<Short>> partition(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        localArrayList1.add(Short.valueOf(s));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Short.valueOf(s));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @NotNull
  public static final Pair<List<Boolean>, List<Boolean>> partition(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfBoolean[i];
      if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {
        localArrayList1.add(Boolean.valueOf(k));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(Boolean.valueOf(k));
      }
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte random(@NotNull byte[] paramArrayOfByte)
  {
    return ArraysKt.random(paramArrayOfByte, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final byte random(@NotNull byte[] paramArrayOfByte, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfByte[paramRandom.nextInt(paramArrayOfByte.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final char random(@NotNull char[] paramArrayOfChar)
  {
    return ArraysKt.random(paramArrayOfChar, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final char random(@NotNull char[] paramArrayOfChar, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfChar[paramRandom.nextInt(paramArrayOfChar.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final double random(@NotNull double[] paramArrayOfDouble)
  {
    return ArraysKt.random(paramArrayOfDouble, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final double random(@NotNull double[] paramArrayOfDouble, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfDouble[paramRandom.nextInt(paramArrayOfDouble.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final float random(@NotNull float[] paramArrayOfFloat)
  {
    return ArraysKt.random(paramArrayOfFloat, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final float random(@NotNull float[] paramArrayOfFloat, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfFloat[paramRandom.nextInt(paramArrayOfFloat.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int random(@NotNull int[] paramArrayOfInt)
  {
    return ArraysKt.random(paramArrayOfInt, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final int random(@NotNull int[] paramArrayOfInt, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfInt[paramRandom.nextInt(paramArrayOfInt.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long random(@NotNull long[] paramArrayOfLong)
  {
    return ArraysKt.random(paramArrayOfLong, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final long random(@NotNull long[] paramArrayOfLong, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfLong[paramRandom.nextInt(paramArrayOfLong.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> T random(@NotNull T[] paramArrayOfT)
  {
    return ArraysKt.random(paramArrayOfT, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final <T> T random(@NotNull T[] paramArrayOfT, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfT[paramRandom.nextInt(paramArrayOfT.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short random(@NotNull short[] paramArrayOfShort)
  {
    return ArraysKt.random(paramArrayOfShort, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final short random(@NotNull short[] paramArrayOfShort, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfShort[paramRandom.nextInt(paramArrayOfShort.length)];
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean random(@NotNull boolean[] paramArrayOfBoolean)
  {
    return ArraysKt.random(paramArrayOfBoolean, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final boolean random(@NotNull boolean[] paramArrayOfBoolean, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfBoolean[paramRandom.nextInt(paramArrayOfBoolean.length)];
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Boolean randomOrNull(@NotNull boolean[] paramArrayOfBoolean)
  {
    return ArraysKt.randomOrNull(paramArrayOfBoolean, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Boolean randomOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Boolean.valueOf(paramArrayOfBoolean[paramRandom.nextInt(paramArrayOfBoolean.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Byte randomOrNull(@NotNull byte[] paramArrayOfByte)
  {
    return ArraysKt.randomOrNull(paramArrayOfByte, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Byte randomOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Byte.valueOf(paramArrayOfByte[paramRandom.nextInt(paramArrayOfByte.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Character randomOrNull(@NotNull char[] paramArrayOfChar)
  {
    return ArraysKt.randomOrNull(paramArrayOfChar, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character randomOrNull(@NotNull char[] paramArrayOfChar, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramArrayOfChar[paramRandom.nextInt(paramArrayOfChar.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Double randomOrNull(@NotNull double[] paramArrayOfDouble)
  {
    return ArraysKt.randomOrNull(paramArrayOfDouble, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Double randomOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Double.valueOf(paramArrayOfDouble[paramRandom.nextInt(paramArrayOfDouble.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Float randomOrNull(@NotNull float[] paramArrayOfFloat)
  {
    return ArraysKt.randomOrNull(paramArrayOfFloat, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Float randomOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Float.valueOf(paramArrayOfFloat[paramRandom.nextInt(paramArrayOfFloat.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Integer randomOrNull(@NotNull int[] paramArrayOfInt)
  {
    return ArraysKt.randomOrNull(paramArrayOfInt, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Integer randomOrNull(@NotNull int[] paramArrayOfInt, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Integer.valueOf(paramArrayOfInt[paramRandom.nextInt(paramArrayOfInt.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Long randomOrNull(@NotNull long[] paramArrayOfLong)
  {
    return ArraysKt.randomOrNull(paramArrayOfLong, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Long randomOrNull(@NotNull long[] paramArrayOfLong, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Long.valueOf(paramArrayOfLong[paramRandom.nextInt(paramArrayOfLong.length)]);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> T randomOrNull(@NotNull T[] paramArrayOfT)
  {
    return ArraysKt.randomOrNull(paramArrayOfT, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <T> T randomOrNull(@NotNull T[] paramArrayOfT, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return paramArrayOfT[paramRandom.nextInt(paramArrayOfT.length)];
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Short randomOrNull(@NotNull short[] paramArrayOfShort)
  {
    return ArraysKt.randomOrNull(paramArrayOfShort, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Short randomOrNull(@NotNull short[] paramArrayOfShort, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Short.valueOf(paramArrayOfShort[paramRandom.nextInt(paramArrayOfShort.length)]);
  }
  
  public static final byte reduce(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Byte, ? super Byte, Byte> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    byte b1 = paramArrayOfByte[0];
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        b1 = ((Number)paramFunction2.invoke(Byte.valueOf(b1), Byte.valueOf(paramArrayOfByte[i]))).byteValue();
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    byte b2 = b1;
    return b2;
  }
  
  public static final char reduce(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    char c1 = paramArrayOfChar[0];
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction2.invoke(Character.valueOf(c1), Character.valueOf(paramArrayOfChar[i]))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return c2;
  }
  
  public static final double reduce(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Double, ? super Double, Double> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    double d2 = paramArrayOfDouble[0];
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d1 = d2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        d2 = ((Number)paramFunction2.invoke(Double.valueOf(d2), Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
        d1 = d2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return d1;
  }
  
  public static final float reduce(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Float, ? super Float, Float> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    float f1 = paramArrayOfFloat[0];
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        f1 = ((Number)paramFunction2.invoke(Float.valueOf(f1), Float.valueOf(paramArrayOfFloat[i]))).floatValue();
        f2 = f1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    float f2 = f1;
    return f2;
  }
  
  public static final int reduce(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Integer> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int j = paramArrayOfInt[0];
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      i = 1;
      for (;;)
      {
        j = ((Number)paramFunction2.invoke(Integer.valueOf(j), Integer.valueOf(paramArrayOfInt[i]))).intValue();
        k = j;
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    int k = j;
    return k;
  }
  
  public static final long reduce(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Long, ? super Long, Long> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    long l2 = paramArrayOfLong[0];
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        l2 = ((Number)paramFunction2.invoke(Long.valueOf(l2), Long.valueOf(paramArrayOfLong[i]))).longValue();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return l1;
  }
  
  public static final <S, T extends S> S reduce(@NotNull T[] paramArrayOfT, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    Object localObject2 = paramArrayOfT[0];
    int k = ArraysKt.getLastIndex(paramArrayOfT);
    Object localObject1 = localObject2;
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        localObject2 = paramFunction2.invoke(localObject2, paramArrayOfT[i]);
        localObject1 = localObject2;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return localObject1;
  }
  
  public static final short reduce(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Short, ? super Short, Short> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    short s1 = paramArrayOfShort[0];
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        s1 = ((Number)paramFunction2.invoke(Short.valueOf(s1), Short.valueOf(paramArrayOfShort[i]))).shortValue();
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    short s2 = s1;
    return s2;
  }
  
  public static final boolean reduce(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int k = paramArrayOfBoolean[0];
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    boolean bool1;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        bool1 = ((Boolean)paramFunction2.invoke(Boolean.valueOf(k), Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue();
        bool2 = bool1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  public static final byte reduceIndexed(@NotNull byte[] paramArrayOfByte, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    byte b1 = paramArrayOfByte[0];
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        b1 = ((Number)paramFunction3.invoke(Integer.valueOf(i), Byte.valueOf(b1), Byte.valueOf(paramArrayOfByte[i]))).byteValue();
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    byte b2 = b1;
    return b2;
  }
  
  public static final char reduceIndexed(@NotNull char[] paramArrayOfChar, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    char c1 = paramArrayOfChar[0];
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(c1), Character.valueOf(paramArrayOfChar[i]))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return c2;
  }
  
  public static final double reduceIndexed(@NotNull double[] paramArrayOfDouble, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    double d2 = paramArrayOfDouble[0];
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d1 = d2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        d2 = ((Number)paramFunction3.invoke(Integer.valueOf(i), Double.valueOf(d2), Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
        d1 = d2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return d1;
  }
  
  public static final float reduceIndexed(@NotNull float[] paramArrayOfFloat, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    float f1 = paramArrayOfFloat[0];
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        f1 = ((Number)paramFunction3.invoke(Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(paramArrayOfFloat[i]))).floatValue();
        f2 = f1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    float f2 = f1;
    return f2;
  }
  
  public static final int reduceIndexed(@NotNull int[] paramArrayOfInt, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int j = paramArrayOfInt[0];
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      i = 1;
      for (;;)
      {
        j = ((Number)paramFunction3.invoke(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramArrayOfInt[i]))).intValue();
        k = j;
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    int k = j;
    return k;
  }
  
  public static final long reduceIndexed(@NotNull long[] paramArrayOfLong, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    long l2 = paramArrayOfLong[0];
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        l2 = ((Number)paramFunction3.invoke(Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(paramArrayOfLong[i]))).longValue();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return l1;
  }
  
  public static final <S, T extends S> S reduceIndexed(@NotNull T[] paramArrayOfT, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    Object localObject2 = paramArrayOfT[0];
    int k = ArraysKt.getLastIndex(paramArrayOfT);
    Object localObject1 = localObject2;
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        localObject2 = paramFunction3.invoke(Integer.valueOf(i), localObject2, paramArrayOfT[i]);
        localObject1 = localObject2;
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return localObject1;
  }
  
  public static final short reduceIndexed(@NotNull short[] paramArrayOfShort, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    short s1 = paramArrayOfShort[0];
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        s1 = ((Number)paramFunction3.invoke(Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(paramArrayOfShort[i]))).shortValue();
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    short s2 = s1;
    return s2;
  }
  
  public static final boolean reduceIndexed(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int k = paramArrayOfBoolean[0];
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    boolean bool1;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        bool1 = ((Boolean)paramFunction3.invoke(Integer.valueOf(i), Boolean.valueOf(k), Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue();
        bool2 = bool1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Boolean reduceOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int k = paramArrayOfBoolean[0];
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    boolean bool1;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        bool1 = ((Boolean)paramFunction2.invoke(Boolean.valueOf(k), Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue();
        bool2 = bool1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    boolean bool2 = bool1;
    return Boolean.valueOf(bool2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Byte reduceOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Byte, ? super Byte, Byte> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    byte b1 = paramArrayOfByte[0];
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        b1 = ((Number)paramFunction2.invoke(Byte.valueOf(b1), Byte.valueOf(paramArrayOfByte[i]))).byteValue();
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    byte b2 = b1;
    return Byte.valueOf(b2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character reduceOrNull(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramArrayOfChar[0];
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction2.invoke(Character.valueOf(c1), Character.valueOf(paramArrayOfChar[i]))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Double reduceOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Double, ? super Double, Double> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    double d2 = paramArrayOfDouble[0];
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    double d1 = d2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        d2 = ((Number)paramFunction2.invoke(Double.valueOf(d2), Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
        d1 = d2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return Double.valueOf(d1);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Float reduceOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Float, ? super Float, Float> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    float f1 = paramArrayOfFloat[0];
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        f1 = ((Number)paramFunction2.invoke(Float.valueOf(f1), Float.valueOf(paramArrayOfFloat[i]))).floatValue();
        f2 = f1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    float f2 = f1;
    return Float.valueOf(f2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Integer reduceOrNull(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Integer> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    int j = paramArrayOfInt[0];
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      i = 1;
      for (;;)
      {
        j = ((Number)paramFunction2.invoke(Integer.valueOf(j), Integer.valueOf(paramArrayOfInt[i]))).intValue();
        k = j;
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    int k = j;
    return Integer.valueOf(k);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Long reduceOrNull(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Long, ? super Long, Long> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    long l2 = paramArrayOfLong[0];
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        l2 = ((Number)paramFunction2.invoke(Long.valueOf(l2), Long.valueOf(paramArrayOfLong[i]))).longValue();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return Long.valueOf(l1);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <S, T extends S> S reduceOrNull(@NotNull T[] paramArrayOfT, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Object localObject1;
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      localObject1 = null;
    }
    label38:
    Object localObject2;
    int k;
    do
    {
      return localObject1;
      i = 0;
      break;
      localObject2 = paramArrayOfT[0];
      k = ArraysKt.getLastIndex(paramArrayOfT);
      localObject1 = localObject2;
    } while (1 > k);
    int i = j;
    for (;;)
    {
      localObject2 = paramFunction2.invoke(localObject2, paramArrayOfT[i]);
      localObject1 = localObject2;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Short reduceOrNull(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Short, ? super Short, Short> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    short s1 = paramArrayOfShort[0];
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        s1 = ((Number)paramFunction2.invoke(Short.valueOf(s1), Short.valueOf(paramArrayOfShort[i]))).shortValue();
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    short s2 = s1;
    return Short.valueOf(s2);
  }
  
  public static final byte reduceRight(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Byte, ? super Byte, Byte> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    byte b = paramArrayOfByte[j];
    while (i >= 0)
    {
      b = ((Number)paramFunction2.invoke(Byte.valueOf(paramArrayOfByte[i]), Byte.valueOf(b))).byteValue();
      i -= 1;
    }
    return b;
  }
  
  public static final char reduceRight(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    char c = paramArrayOfChar[j];
    while (i >= 0)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(paramArrayOfChar[i]), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return c;
  }
  
  public static final double reduceRight(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Double, ? super Double, Double> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    double d = paramArrayOfDouble[j];
    while (i >= 0)
    {
      d = ((Number)paramFunction2.invoke(Double.valueOf(paramArrayOfDouble[i]), Double.valueOf(d))).doubleValue();
      i -= 1;
    }
    return d;
  }
  
  public static final float reduceRight(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Float, ? super Float, Float> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    float f = paramArrayOfFloat[j];
    while (i >= 0)
    {
      f = ((Number)paramFunction2.invoke(Float.valueOf(paramArrayOfFloat[i]), Float.valueOf(f))).floatValue();
      i -= 1;
    }
    return f;
  }
  
  public static final int reduceRight(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Integer> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfInt);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    j = paramArrayOfInt[j];
    while (i >= 0)
    {
      j = ((Number)paramFunction2.invoke(Integer.valueOf(paramArrayOfInt[i]), Integer.valueOf(j))).intValue();
      i -= 1;
    }
    return j;
  }
  
  public static final long reduceRight(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Long, ? super Long, Long> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    long l = paramArrayOfLong[j];
    while (i >= 0)
    {
      l = ((Number)paramFunction2.invoke(Long.valueOf(paramArrayOfLong[i]), Long.valueOf(l))).longValue();
      i -= 1;
    }
    return l;
  }
  
  public static final <S, T extends S> S reduceRight(@NotNull T[] paramArrayOfT, @NotNull Function2<? super T, ? super S, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfT);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    Object localObject = paramArrayOfT[j];
    while (i >= 0)
    {
      localObject = paramFunction2.invoke(paramArrayOfT[i], localObject);
      i -= 1;
    }
    return localObject;
  }
  
  public static final short reduceRight(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Short, ? super Short, Short> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    short s = paramArrayOfShort[j];
    while (i >= 0)
    {
      s = ((Number)paramFunction2.invoke(Short.valueOf(paramArrayOfShort[i]), Short.valueOf(s))).shortValue();
      i -= 1;
    }
    return s;
  }
  
  public static final boolean reduceRight(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    int k = paramArrayOfBoolean[j];
    boolean bool;
    while (i >= 0)
    {
      bool = ((Boolean)paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean[i]), Boolean.valueOf(k))).booleanValue();
      i -= 1;
    }
    return bool;
  }
  
  public static final byte reduceRightIndexed(@NotNull byte[] paramArrayOfByte, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    byte b = paramArrayOfByte[j];
    while (i >= 0)
    {
      b = ((Number)paramFunction3.invoke(Integer.valueOf(i), Byte.valueOf(paramArrayOfByte[i]), Byte.valueOf(b))).byteValue();
      i -= 1;
    }
    return b;
  }
  
  public static final char reduceRightIndexed(@NotNull char[] paramArrayOfChar, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    char c = paramArrayOfChar[j];
    while (i >= 0)
    {
      c = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramArrayOfChar[i]), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return c;
  }
  
  public static final double reduceRightIndexed(@NotNull double[] paramArrayOfDouble, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    double d = paramArrayOfDouble[j];
    while (i >= 0)
    {
      d = ((Number)paramFunction3.invoke(Integer.valueOf(i), Double.valueOf(paramArrayOfDouble[i]), Double.valueOf(d))).doubleValue();
      i -= 1;
    }
    return d;
  }
  
  public static final float reduceRightIndexed(@NotNull float[] paramArrayOfFloat, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    float f = paramArrayOfFloat[j];
    while (i >= 0)
    {
      f = ((Number)paramFunction3.invoke(Integer.valueOf(i), Float.valueOf(paramArrayOfFloat[i]), Float.valueOf(f))).floatValue();
      i -= 1;
    }
    return f;
  }
  
  public static final int reduceRightIndexed(@NotNull int[] paramArrayOfInt, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfInt);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    j = paramArrayOfInt[j];
    while (i >= 0)
    {
      j = ((Number)paramFunction3.invoke(Integer.valueOf(i), Integer.valueOf(paramArrayOfInt[i]), Integer.valueOf(j))).intValue();
      i -= 1;
    }
    return j;
  }
  
  public static final long reduceRightIndexed(@NotNull long[] paramArrayOfLong, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    long l = paramArrayOfLong[j];
    while (i >= 0)
    {
      l = ((Number)paramFunction3.invoke(Integer.valueOf(i), Long.valueOf(paramArrayOfLong[i]), Long.valueOf(l))).longValue();
      i -= 1;
    }
    return l;
  }
  
  public static final <S, T extends S> S reduceRightIndexed(@NotNull T[] paramArrayOfT, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfT);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    Object localObject = paramArrayOfT[j];
    while (i >= 0)
    {
      localObject = paramFunction3.invoke(Integer.valueOf(i), paramArrayOfT[i], localObject);
      i -= 1;
    }
    return localObject;
  }
  
  public static final short reduceRightIndexed(@NotNull short[] paramArrayOfShort, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    short s = paramArrayOfShort[j];
    while (i >= 0)
    {
      s = ((Number)paramFunction3.invoke(Integer.valueOf(i), Short.valueOf(paramArrayOfShort[i]), Short.valueOf(s))).shortValue();
      i -= 1;
    }
    return s;
  }
  
  public static final boolean reduceRightIndexed(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    int k = paramArrayOfBoolean[j];
    boolean bool;
    while (i >= 0)
    {
      bool = ((Boolean)paramFunction3.invoke(Integer.valueOf(i), Boolean.valueOf(paramArrayOfBoolean[i]), Boolean.valueOf(k))).booleanValue();
      i -= 1;
    }
    return bool;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Boolean reduceRightOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    int k = paramArrayOfBoolean[j];
    boolean bool;
    while (i >= 0)
    {
      bool = ((Boolean)paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean[i]), Boolean.valueOf(k))).booleanValue();
      i -= 1;
    }
    return Boolean.valueOf(bool);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Byte reduceRightOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Function2<? super Byte, ? super Byte, Byte> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    byte b = paramArrayOfByte[j];
    while (i >= 0)
    {
      b = ((Number)paramFunction2.invoke(Byte.valueOf(paramArrayOfByte[i]), Byte.valueOf(b))).byteValue();
      i -= 1;
    }
    return Byte.valueOf(b);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character reduceRightOrNull(@NotNull char[] paramArrayOfChar, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfChar);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    char c = paramArrayOfChar[j];
    while (i >= 0)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(paramArrayOfChar[i]), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return Character.valueOf(c);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Double reduceRightOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Function2<? super Double, ? super Double, Double> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    double d = paramArrayOfDouble[j];
    while (i >= 0)
    {
      d = ((Number)paramFunction2.invoke(Double.valueOf(paramArrayOfDouble[i]), Double.valueOf(d))).doubleValue();
      i -= 1;
    }
    return Double.valueOf(d);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Float reduceRightOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Function2<? super Float, ? super Float, Float> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    float f = paramArrayOfFloat[j];
    while (i >= 0)
    {
      f = ((Number)paramFunction2.invoke(Float.valueOf(paramArrayOfFloat[i]), Float.valueOf(f))).floatValue();
      i -= 1;
    }
    return Float.valueOf(f);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Integer reduceRightOrNull(@NotNull int[] paramArrayOfInt, @NotNull Function2<? super Integer, ? super Integer, Integer> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfInt);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    j = paramArrayOfInt[j];
    while (i >= 0)
    {
      j = ((Number)paramFunction2.invoke(Integer.valueOf(paramArrayOfInt[i]), Integer.valueOf(j))).intValue();
      i -= 1;
    }
    return Integer.valueOf(j);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Long reduceRightOrNull(@NotNull long[] paramArrayOfLong, @NotNull Function2<? super Long, ? super Long, Long> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    long l = paramArrayOfLong[j];
    while (i >= 0)
    {
      l = ((Number)paramFunction2.invoke(Long.valueOf(paramArrayOfLong[i]), Long.valueOf(l))).longValue();
      i -= 1;
    }
    return Long.valueOf(l);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <S, T extends S> S reduceRightOrNull(@NotNull T[] paramArrayOfT, @NotNull Function2<? super T, ? super S, ? extends S> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfT);
    Object localObject2;
    if (j < 0)
    {
      localObject2 = null;
      return localObject2;
    }
    int i = j - 1;
    Object localObject1 = paramArrayOfT[j];
    for (;;)
    {
      localObject2 = localObject1;
      if (i < 0) {
        break;
      }
      localObject1 = paramFunction2.invoke(paramArrayOfT[i], localObject1);
      i -= 1;
    }
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Short reduceRightOrNull(@NotNull short[] paramArrayOfShort, @NotNull Function2<? super Short, ? super Short, Short> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    short s = paramArrayOfShort[j];
    while (i >= 0)
    {
      s = ((Number)paramFunction2.invoke(Short.valueOf(paramArrayOfShort[i]), Short.valueOf(s))).shortValue();
      i -= 1;
    }
    return Short.valueOf(s);
  }
  
  @NotNull
  public static final <T> T[] requireNoNulls(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$requireNoNulls");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfT[i] == null) {
        throw ((Throwable)new IllegalArgumentException("null element found in " + paramArrayOfT + '.'));
      }
      i += 1;
    }
    return paramArrayOfT;
  }
  
  public static final void reverse(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reverse");
    int m = paramArrayOfByte.length / 2 - 1;
    if (m < 0) {}
    int k;
    int j;
    do
    {
      return;
      k = ArraysKt.getLastIndex(paramArrayOfByte);
      j = 0;
    } while (m > 0);
    for (;;)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[k];
      paramArrayOfByte[k] = i;
      k -= 1;
      if (j == m) {
        break;
      }
      j += 1;
    }
  }
  
  public static final void reverse(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reverse");
    int m = paramArrayOfChar.length / 2 - 1;
    if (m < 0) {}
    int k;
    int j;
    do
    {
      return;
      k = ArraysKt.getLastIndex(paramArrayOfChar);
      j = 0;
    } while (m > 0);
    for (;;)
    {
      int i = paramArrayOfChar[j];
      paramArrayOfChar[j] = paramArrayOfChar[k];
      paramArrayOfChar[k] = i;
      k -= 1;
      if (j == m) {
        break;
      }
      j += 1;
    }
  }
  
  public static final void reverse(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reverse");
    int k = paramArrayOfDouble.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfDouble);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      double d = paramArrayOfDouble[i];
      paramArrayOfDouble[i] = paramArrayOfDouble[j];
      paramArrayOfDouble[j] = d;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  public static final void reverse(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reverse");
    int k = paramArrayOfFloat.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfFloat);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      float f = paramArrayOfFloat[i];
      paramArrayOfFloat[i] = paramArrayOfFloat[j];
      paramArrayOfFloat[j] = f;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  public static final void reverse(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reverse");
    int k = paramArrayOfInt.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfInt);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      int m = paramArrayOfInt[i];
      paramArrayOfInt[i] = paramArrayOfInt[j];
      paramArrayOfInt[j] = m;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  public static final void reverse(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reverse");
    int k = paramArrayOfLong.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfLong);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      long l = paramArrayOfLong[i];
      paramArrayOfLong[i] = paramArrayOfLong[j];
      paramArrayOfLong[j] = l;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  public static final <T> void reverse(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reverse");
    int k = paramArrayOfT.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfT);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      T ? = paramArrayOfT[i];
      paramArrayOfT[i] = paramArrayOfT[j];
      paramArrayOfT[j] = ?;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  public static final void reverse(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reverse");
    int m = paramArrayOfShort.length / 2 - 1;
    if (m < 0) {}
    int k;
    int j;
    do
    {
      return;
      k = ArraysKt.getLastIndex(paramArrayOfShort);
      j = 0;
    } while (m > 0);
    for (;;)
    {
      int i = paramArrayOfShort[j];
      paramArrayOfShort[j] = paramArrayOfShort[k];
      paramArrayOfShort[k] = i;
      k -= 1;
      if (j == m) {
        break;
      }
      j += 1;
    }
  }
  
  public static final void reverse(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reverse");
    int k = paramArrayOfBoolean.length / 2 - 1;
    if (k < 0) {}
    int j;
    int i;
    do
    {
      return;
      j = ArraysKt.getLastIndex(paramArrayOfBoolean);
      i = 0;
    } while (k > 0);
    for (;;)
    {
      int m = paramArrayOfBoolean[i];
      paramArrayOfBoolean[i] = paramArrayOfBoolean[j];
      paramArrayOfBoolean[j] = m;
      j -= 1;
      if (i == k) {
        break;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Byte> reversed(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reversed");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfByte = ArraysKt.toMutableList(paramArrayOfByte);
    CollectionsKt.reverse(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final List<Character> reversed(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reversed");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfChar = ArraysKt.toMutableList(paramArrayOfChar);
    CollectionsKt.reverse(paramArrayOfChar);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final List<Double> reversed(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reversed");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfDouble = ArraysKt.toMutableList(paramArrayOfDouble);
    CollectionsKt.reverse(paramArrayOfDouble);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final List<Float> reversed(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reversed");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfFloat = ArraysKt.toMutableList(paramArrayOfFloat);
    CollectionsKt.reverse(paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final List<Integer> reversed(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reversed");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfInt = ArraysKt.toMutableList(paramArrayOfInt);
    CollectionsKt.reverse(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final List<Long> reversed(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reversed");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfLong = ArraysKt.toMutableList(paramArrayOfLong);
    CollectionsKt.reverse(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T> List<T> reversed(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reversed");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfT = ArraysKt.toMutableList(paramArrayOfT);
    CollectionsKt.reverse(paramArrayOfT);
    return paramArrayOfT;
  }
  
  @NotNull
  public static final List<Short> reversed(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reversed");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfShort = ArraysKt.toMutableList(paramArrayOfShort);
    CollectionsKt.reverse(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final List<Boolean> reversed(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reversed");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfBoolean = ArraysKt.toMutableList(paramArrayOfBoolean);
    CollectionsKt.reverse(paramArrayOfBoolean);
    return paramArrayOfBoolean;
  }
  
  @NotNull
  public static final byte[] reversedArray(@NotNull byte[] paramArrayOfByte)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reversedArray");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int k = ArraysKt.getLastIndex(paramArrayOfByte);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfByte[(k - i)] = paramArrayOfByte[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static final char[] reversedArray(@NotNull char[] paramArrayOfChar)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$reversedArray");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfChar;
    }
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    int k = ArraysKt.getLastIndex(paramArrayOfChar);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfChar[(k - i)] = paramArrayOfChar[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfChar;
  }
  
  @NotNull
  public static final double[] reversedArray(@NotNull double[] paramArrayOfDouble)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$reversedArray");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfDouble;
    }
    double[] arrayOfDouble = new double[paramArrayOfDouble.length];
    int k = ArraysKt.getLastIndex(paramArrayOfDouble);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfDouble[(k - i)] = paramArrayOfDouble[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public static final float[] reversedArray(@NotNull float[] paramArrayOfFloat)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$reversedArray");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfFloat;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int k = ArraysKt.getLastIndex(paramArrayOfFloat);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfFloat[(k - i)] = paramArrayOfFloat[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public static final int[] reversedArray(@NotNull int[] paramArrayOfInt)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reversedArray");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int k = ArraysKt.getLastIndex(paramArrayOfInt);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfInt[(k - i)] = paramArrayOfInt[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfInt;
  }
  
  @NotNull
  public static final long[] reversedArray(@NotNull long[] paramArrayOfLong)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reversedArray");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfLong;
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int k = ArraysKt.getLastIndex(paramArrayOfLong);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfLong[(k - i)] = paramArrayOfLong[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfLong;
  }
  
  @NotNull
  public static final <T> T[] reversedArray(@NotNull T[] paramArrayOfT)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$reversedArray");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfT;
    }
    Object[] arrayOfObject = ArraysKt.arrayOfNulls(paramArrayOfT, paramArrayOfT.length);
    int k = ArraysKt.getLastIndex(paramArrayOfT);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfObject[(k - i)] = paramArrayOfT[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfObject;
  }
  
  @NotNull
  public static final short[] reversedArray(@NotNull short[] paramArrayOfShort)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reversedArray");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfShort;
    }
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    int k = ArraysKt.getLastIndex(paramArrayOfShort);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfShort[(k - i)] = paramArrayOfShort[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfShort;
  }
  
  @NotNull
  public static final boolean[] reversedArray(@NotNull boolean[] paramArrayOfBoolean)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$reversedArray");
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfBoolean;
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
    int k = ArraysKt.getLastIndex(paramArrayOfBoolean);
    if (k <= 0)
    {
      i = j;
      for (;;)
      {
        arrayOfBoolean[(k - i)] = paramArrayOfBoolean[i];
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
    return arrayOfBoolean;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull byte[] paramArrayOfByte, R paramR, Function2<? super R, ? super Byte, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfByte.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Byte.valueOf(paramArrayOfByte[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull char[] paramArrayOfChar, R paramR, Function2<? super R, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfChar.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfChar.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Character.valueOf(paramArrayOfChar[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull double[] paramArrayOfDouble, R paramR, Function2<? super R, ? super Double, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfDouble.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfDouble.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Double.valueOf(paramArrayOfDouble[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull float[] paramArrayOfFloat, R paramR, Function2<? super R, ? super Float, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfFloat.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Float.valueOf(paramArrayOfFloat[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull int[] paramArrayOfInt, R paramR, Function2<? super R, ? super Integer, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfInt.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Integer.valueOf(paramArrayOfInt[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull long[] paramArrayOfLong, R paramR, Function2<? super R, ? super Long, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfLong.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Long.valueOf(paramArrayOfLong[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> List<R> scan(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$scan");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfT.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, paramArrayOfT[i]);
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull short[] paramArrayOfShort, R paramR, Function2<? super R, ? super Short, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfShort.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfShort.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Short.valueOf(paramArrayOfShort[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan(@NotNull boolean[] paramArrayOfBoolean, R paramR, Function2<? super R, ? super Boolean, ? extends R> paramFunction2)
  {
    int j = 0;
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfBoolean.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfBoolean.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction2.invoke(paramR, Boolean.valueOf(paramArrayOfBoolean[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull byte[] paramArrayOfByte, R paramR, Function3<? super Integer, ? super R, ? super Byte, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfByte.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Byte.valueOf(paramArrayOfByte[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull char[] paramArrayOfChar, R paramR, Function3<? super Integer, ? super R, ? super Character, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfChar.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfChar.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Character.valueOf(paramArrayOfChar[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull double[] paramArrayOfDouble, R paramR, Function3<? super Integer, ? super R, ? super Double, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfDouble.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfDouble.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Double.valueOf(paramArrayOfDouble[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull float[] paramArrayOfFloat, R paramR, Function3<? super Integer, ? super R, ? super Float, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfFloat.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Float.valueOf(paramArrayOfFloat[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull int[] paramArrayOfInt, R paramR, Function3<? super Integer, ? super R, ? super Integer, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfInt.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Integer.valueOf(paramArrayOfInt[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull long[] paramArrayOfLong, R paramR, Function3<? super Integer, ? super R, ? super Long, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfLong.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Long.valueOf(paramArrayOfLong[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T, R> List<R> scanIndexed(@NotNull T[] paramArrayOfT, R paramR, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$scanIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfT.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, paramArrayOfT[i]);
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull short[] paramArrayOfShort, R paramR, Function3<? super Integer, ? super R, ? super Short, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfShort.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfShort.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Short.valueOf(paramArrayOfShort[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed(@NotNull boolean[] paramArrayOfBoolean, R paramR, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> paramFunction3)
  {
    int j = 0;
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfBoolean.length + 1);
    localArrayList.add(paramR);
    int k = paramArrayOfBoolean.length;
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Boolean.valueOf(paramArrayOfBoolean[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Byte> scanReduce(@NotNull byte[] paramArrayOfByte, Function2<? super Byte, ? super Byte, Byte> paramFunction2)
  {
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    byte b = paramArrayOfByte[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length);
    localArrayList.add(Byte.valueOf(b));
    int j = paramArrayOfByte.length;
    i = 1;
    while (i < j)
    {
      b = ((Number)paramFunction2.invoke(Byte.valueOf(b), Byte.valueOf(paramArrayOfByte[i]))).byteValue();
      localArrayList.add(Byte.valueOf(b));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Character> scanReduce(@NotNull char[] paramArrayOfChar, Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    char c = paramArrayOfChar[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfChar.length);
    localArrayList.add(Character.valueOf(c));
    int j = paramArrayOfChar.length;
    i = 1;
    while (i < j)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(c), Character.valueOf(paramArrayOfChar[i]))).charValue();
      localArrayList.add(Character.valueOf(c));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Double> scanReduce(@NotNull double[] paramArrayOfDouble, Function2<? super Double, ? super Double, Double> paramFunction2)
  {
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    double d = paramArrayOfDouble[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfDouble.length);
    localArrayList.add(Double.valueOf(d));
    int j = paramArrayOfDouble.length;
    i = 1;
    while (i < j)
    {
      d = ((Number)paramFunction2.invoke(Double.valueOf(d), Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
      localArrayList.add(Double.valueOf(d));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Float> scanReduce(@NotNull float[] paramArrayOfFloat, Function2<? super Float, ? super Float, Float> paramFunction2)
  {
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    float f = paramArrayOfFloat[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length);
    localArrayList.add(Float.valueOf(f));
    int j = paramArrayOfFloat.length;
    i = 1;
    while (i < j)
    {
      f = ((Number)paramFunction2.invoke(Float.valueOf(f), Float.valueOf(paramArrayOfFloat[i]))).floatValue();
      localArrayList.add(Float.valueOf(f));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Integer> scanReduce(@NotNull int[] paramArrayOfInt, Function2<? super Integer, ? super Integer, Integer> paramFunction2)
  {
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    int j = paramArrayOfInt[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    localArrayList.add(Integer.valueOf(j));
    int k = paramArrayOfInt.length;
    i = 1;
    while (i < k)
    {
      j = ((Number)paramFunction2.invoke(Integer.valueOf(j), Integer.valueOf(paramArrayOfInt[i]))).intValue();
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Long> scanReduce(@NotNull long[] paramArrayOfLong, Function2<? super Long, ? super Long, Long> paramFunction2)
  {
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    long l = paramArrayOfLong[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    localArrayList.add(Long.valueOf(l));
    int j = paramArrayOfLong.length;
    i = 1;
    while (i < j)
    {
      l = ((Number)paramFunction2.invoke(Long.valueOf(l), Long.valueOf(paramArrayOfLong[i]))).longValue();
      localArrayList.add(Long.valueOf(l));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> List<S> scanReduce(@NotNull T[] paramArrayOfT, @NotNull Function2<? super S, ? super T, ? extends S> paramFunction2)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$scanReduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    Object localObject = paramArrayOfT[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfT.length);
    localArrayList.add(localObject);
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      localObject = paramFunction2.invoke(localObject, paramArrayOfT[i]);
      localArrayList.add(localObject);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Short> scanReduce(@NotNull short[] paramArrayOfShort, Function2<? super Short, ? super Short, Short> paramFunction2)
  {
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    short s = paramArrayOfShort[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfShort.length);
    localArrayList.add(Short.valueOf(s));
    int j = paramArrayOfShort.length;
    i = 1;
    while (i < j)
    {
      s = ((Number)paramFunction2.invoke(Short.valueOf(s), Short.valueOf(paramArrayOfShort[i]))).shortValue();
      localArrayList.add(Short.valueOf(s));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Boolean> scanReduce(@NotNull boolean[] paramArrayOfBoolean, Function2<? super Boolean, ? super Boolean, Boolean> paramFunction2)
  {
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    int k = paramArrayOfBoolean[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfBoolean.length);
    localArrayList.add(Boolean.valueOf(k));
    int j = paramArrayOfBoolean.length;
    i = 1;
    while (i < j)
    {
      boolean bool = ((Boolean)paramFunction2.invoke(Boolean.valueOf(k), Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue();
      localArrayList.add(Boolean.valueOf(bool));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Byte> scanReduceIndexed(@NotNull byte[] paramArrayOfByte, Function3<? super Integer, ? super Byte, ? super Byte, Byte> paramFunction3)
  {
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    byte b = paramArrayOfByte[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length);
    localArrayList.add(Byte.valueOf(b));
    int j = paramArrayOfByte.length;
    i = 1;
    while (i < j)
    {
      b = ((Number)paramFunction3.invoke(Integer.valueOf(i), Byte.valueOf(b), Byte.valueOf(paramArrayOfByte[i]))).byteValue();
      localArrayList.add(Byte.valueOf(b));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Character> scanReduceIndexed(@NotNull char[] paramArrayOfChar, Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    char c = paramArrayOfChar[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfChar.length);
    localArrayList.add(Character.valueOf(c));
    int j = paramArrayOfChar.length;
    i = 1;
    while (i < j)
    {
      c = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(c), Character.valueOf(paramArrayOfChar[i]))).charValue();
      localArrayList.add(Character.valueOf(c));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Double> scanReduceIndexed(@NotNull double[] paramArrayOfDouble, Function3<? super Integer, ? super Double, ? super Double, Double> paramFunction3)
  {
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    double d = paramArrayOfDouble[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfDouble.length);
    localArrayList.add(Double.valueOf(d));
    int j = paramArrayOfDouble.length;
    i = 1;
    while (i < j)
    {
      d = ((Number)paramFunction3.invoke(Integer.valueOf(i), Double.valueOf(d), Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
      localArrayList.add(Double.valueOf(d));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Float> scanReduceIndexed(@NotNull float[] paramArrayOfFloat, Function3<? super Integer, ? super Float, ? super Float, Float> paramFunction3)
  {
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    float f = paramArrayOfFloat[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length);
    localArrayList.add(Float.valueOf(f));
    int j = paramArrayOfFloat.length;
    i = 1;
    while (i < j)
    {
      f = ((Number)paramFunction3.invoke(Integer.valueOf(i), Float.valueOf(f), Float.valueOf(paramArrayOfFloat[i]))).floatValue();
      localArrayList.add(Float.valueOf(f));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Integer> scanReduceIndexed(@NotNull int[] paramArrayOfInt, Function3<? super Integer, ? super Integer, ? super Integer, Integer> paramFunction3)
  {
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    int j = paramArrayOfInt[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    localArrayList.add(Integer.valueOf(j));
    int k = paramArrayOfInt.length;
    i = 1;
    while (i < k)
    {
      j = ((Number)paramFunction3.invoke(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramArrayOfInt[i]))).intValue();
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Long> scanReduceIndexed(@NotNull long[] paramArrayOfLong, Function3<? super Integer, ? super Long, ? super Long, Long> paramFunction3)
  {
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    long l = paramArrayOfLong[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    localArrayList.add(Long.valueOf(l));
    int j = paramArrayOfLong.length;
    i = 1;
    while (i < j)
    {
      l = ((Number)paramFunction3.invoke(Integer.valueOf(i), Long.valueOf(l), Long.valueOf(paramArrayOfLong[i]))).longValue();
      localArrayList.add(Long.valueOf(l));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <S, T extends S> List<S> scanReduceIndexed(@NotNull T[] paramArrayOfT, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> paramFunction3)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$scanReduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    Object localObject = paramArrayOfT[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfT.length);
    localArrayList.add(localObject);
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      localObject = paramFunction3.invoke(Integer.valueOf(i), localObject, paramArrayOfT[i]);
      localArrayList.add(localObject);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Short> scanReduceIndexed(@NotNull short[] paramArrayOfShort, Function3<? super Integer, ? super Short, ? super Short, Short> paramFunction3)
  {
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    short s = paramArrayOfShort[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfShort.length);
    localArrayList.add(Short.valueOf(s));
    int j = paramArrayOfShort.length;
    i = 1;
    while (i < j)
    {
      s = ((Number)paramFunction3.invoke(Integer.valueOf(i), Short.valueOf(s), Short.valueOf(paramArrayOfShort[i]))).shortValue();
      localArrayList.add(Short.valueOf(s));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<Boolean> scanReduceIndexed(@NotNull boolean[] paramArrayOfBoolean, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> paramFunction3)
  {
    if (paramArrayOfBoolean.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    int k = paramArrayOfBoolean[0];
    ArrayList localArrayList = new ArrayList(paramArrayOfBoolean.length);
    localArrayList.add(Boolean.valueOf(k));
    int j = paramArrayOfBoolean.length;
    i = 1;
    while (i < j)
    {
      boolean bool = ((Boolean)paramFunction3.invoke(Integer.valueOf(i), Boolean.valueOf(k), Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue();
      localArrayList.add(Boolean.valueOf(bool));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  public static final byte single(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$single");
    switch (paramArrayOfByte.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfByte[0];
  }
  
  public static final byte single(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Byte localByte = (Byte)null;
    int k = paramArrayOfByte.length;
    int j = 0;
    if (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        break label135;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localByte = Byte.valueOf(b);
      i = 1;
    }
    label135:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localByte == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Byte");
      }
      return localByte.byteValue();
    }
  }
  
  public static final char single(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$single");
    switch (paramArrayOfChar.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfChar[0];
  }
  
  public static final char single(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int k = paramArrayOfChar.length;
    int j = 0;
    if (j < k)
    {
      char c = paramArrayOfChar[j];
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        break label135;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localCharacter = Character.valueOf(c);
      i = 1;
    }
    label135:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localCharacter == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
      }
      return localCharacter.charValue();
    }
  }
  
  public static final double single(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$single");
    switch (paramArrayOfDouble.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfDouble[0];
  }
  
  public static final double single(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Double localDouble = (Double)null;
    int k = paramArrayOfDouble.length;
    int j = 0;
    if (j < k)
    {
      double d = paramArrayOfDouble[j];
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        break label139;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localDouble = Double.valueOf(d);
      i = 1;
    }
    label139:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localDouble == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
      }
      return localDouble.doubleValue();
    }
  }
  
  public static final float single(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$single");
    switch (paramArrayOfFloat.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfFloat[0];
  }
  
  public static final float single(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Float localFloat = (Float)null;
    int k = paramArrayOfFloat.length;
    int j = 0;
    if (j < k)
    {
      float f = paramArrayOfFloat[j];
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        break label135;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localFloat = Float.valueOf(f);
      i = 1;
    }
    label135:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localFloat == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
      }
      return localFloat.floatValue();
    }
  }
  
  public static final int single(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$single");
    switch (paramArrayOfInt.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfInt[0];
  }
  
  public static final int single(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Integer localInteger = (Integer)null;
    int k = paramArrayOfInt.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfInt[j];
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(m))).booleanValue()) {
        break label133;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localInteger = Integer.valueOf(m);
      i = 1;
    }
    label133:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localInteger == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      return localInteger.intValue();
    }
  }
  
  public static final long single(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$single");
    switch (paramArrayOfLong.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfLong[0];
  }
  
  public static final long single(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Long localLong = (Long)null;
    int k = paramArrayOfLong.length;
    int j = 0;
    if (j < k)
    {
      long l = paramArrayOfLong[j];
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        break label133;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localLong = Long.valueOf(l);
      i = 1;
    }
    label133:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localLong == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      return localLong.longValue();
    }
  }
  
  public static final <T> T single(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$single");
    switch (paramArrayOfT.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfT[0];
  }
  
  public static final <T> T single(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject = null;
    int k = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      T ? = paramArrayOfT[j];
      if (!((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        break label105;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      i = 1;
      localObject = ?;
    }
    label105:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      return localObject;
    }
  }
  
  public static final short single(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$single");
    switch (paramArrayOfShort.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfShort[0];
  }
  
  public static final short single(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Short localShort = (Short)null;
    int k = paramArrayOfShort.length;
    int j = 0;
    if (j < k)
    {
      short s = paramArrayOfShort[j];
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        break label135;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localShort = Short.valueOf(s);
      i = 1;
    }
    label135:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localShort == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Short");
      }
      return localShort.shortValue();
    }
  }
  
  public static final boolean single(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$single");
    switch (paramArrayOfBoolean.length)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return paramArrayOfBoolean[0];
  }
  
  public static final boolean single(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Boolean localBoolean = (Boolean)null;
    int k = paramArrayOfBoolean.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfBoolean[j];
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(m))).booleanValue()) {
        break label133;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localBoolean = Boolean.valueOf(m);
      i = 1;
    }
    label133:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localBoolean == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      }
      return localBoolean.booleanValue();
    }
  }
  
  @Nullable
  public static final Boolean singleOrNull(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$singleOrNull");
    if (paramArrayOfBoolean.length == 1) {
      return Boolean.valueOf(paramArrayOfBoolean[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Boolean singleOrNull(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Boolean localBoolean = (Boolean)null;
    int k = paramArrayOfBoolean.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfBoolean[j];
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(m))).booleanValue()) {
        break label88;
      }
      if (i != 0) {
        label63:
        return null;
      }
      localBoolean = Boolean.valueOf(m);
      i = 1;
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label63;
      }
      return localBoolean;
    }
  }
  
  @Nullable
  public static final Byte singleOrNull(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$singleOrNull");
    if (paramArrayOfByte.length == 1) {
      return Byte.valueOf(paramArrayOfByte[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Byte singleOrNull(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Byte localByte = (Byte)null;
    int k = paramArrayOfByte.length;
    int j = 0;
    if (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {
        break label90;
      }
      if (i != 0) {
        label64:
        return null;
      }
      localByte = Byte.valueOf(b);
      i = 1;
    }
    label90:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label64;
      }
      return localByte;
    }
  }
  
  @Nullable
  public static final Character singleOrNull(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$singleOrNull");
    if (paramArrayOfChar.length == 1) {
      return Character.valueOf(paramArrayOfChar[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Character singleOrNull(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int k = paramArrayOfChar.length;
    int j = 0;
    if (j < k)
    {
      char c = paramArrayOfChar[j];
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        break label90;
      }
      if (i != 0) {
        label64:
        return null;
      }
      localCharacter = Character.valueOf(c);
      i = 1;
    }
    label90:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label64;
      }
      return localCharacter;
    }
  }
  
  @Nullable
  public static final Double singleOrNull(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$singleOrNull");
    if (paramArrayOfDouble.length == 1) {
      return Double.valueOf(paramArrayOfDouble[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Double singleOrNull(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Double localDouble = (Double)null;
    int k = paramArrayOfDouble.length;
    int j = 0;
    if (j < k)
    {
      double d = paramArrayOfDouble[j];
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {
        break label94;
      }
      if (i != 0) {
        label66:
        return null;
      }
      localDouble = Double.valueOf(d);
      i = 1;
    }
    label94:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label66;
      }
      return localDouble;
    }
  }
  
  @Nullable
  public static final Float singleOrNull(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$singleOrNull");
    if (paramArrayOfFloat.length == 1) {
      return Float.valueOf(paramArrayOfFloat[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Float singleOrNull(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Float localFloat = (Float)null;
    int k = paramArrayOfFloat.length;
    int j = 0;
    if (j < k)
    {
      float f = paramArrayOfFloat[j];
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {
        break label90;
      }
      if (i != 0) {
        label64:
        return null;
      }
      localFloat = Float.valueOf(f);
      i = 1;
    }
    label90:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label64;
      }
      return localFloat;
    }
  }
  
  @Nullable
  public static final Integer singleOrNull(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$singleOrNull");
    if (paramArrayOfInt.length == 1) {
      return Integer.valueOf(paramArrayOfInt[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Integer singleOrNull(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Integer localInteger = (Integer)null;
    int k = paramArrayOfInt.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfInt[j];
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(m))).booleanValue()) {
        break label88;
      }
      if (i != 0) {
        label63:
        return null;
      }
      localInteger = Integer.valueOf(m);
      i = 1;
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label63;
      }
      return localInteger;
    }
  }
  
  @Nullable
  public static final Long singleOrNull(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$singleOrNull");
    if (paramArrayOfLong.length == 1) {
      return Long.valueOf(paramArrayOfLong[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Long singleOrNull(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Long localLong = (Long)null;
    int k = paramArrayOfLong.length;
    int j = 0;
    if (j < k)
    {
      long l = paramArrayOfLong[j];
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {
        break label88;
      }
      if (i != 0) {
        label63:
        return null;
      }
      localLong = Long.valueOf(l);
      i = 1;
    }
    label88:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label63;
      }
      return localLong;
    }
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$singleOrNull");
    if (paramArrayOfT.length == 1) {
      return paramArrayOfT[0];
    }
    return null;
  }
  
  @Nullable
  public static final <T> T singleOrNull(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int k = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    Object localObject = null;
    if (j < k)
    {
      T ? = paramArrayOfT[j];
      if (!((Boolean)paramFunction1.invoke(?)).booleanValue()) {
        break label82;
      }
      if (i != 0)
      {
        localObject = null;
        label60:
        return localObject;
      }
      i = 1;
      localObject = ?;
    }
    label82:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        break label60;
      }
      return null;
    }
  }
  
  @Nullable
  public static final Short singleOrNull(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$singleOrNull");
    if (paramArrayOfShort.length == 1) {
      return Short.valueOf(paramArrayOfShort[0]);
    }
    return null;
  }
  
  @Nullable
  public static final Short singleOrNull(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Short localShort = (Short)null;
    int k = paramArrayOfShort.length;
    int j = 0;
    if (j < k)
    {
      short s = paramArrayOfShort[j];
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {
        break label90;
      }
      if (i != 0) {
        label64:
        return null;
      }
      localShort = Short.valueOf(s);
      i = 1;
    }
    label90:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label64;
      }
      return localShort;
    }
  }
  
  @NotNull
  public static final List<Byte> slice(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Byte.valueOf(paramArrayOfByte[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Byte> slice(@NotNull byte[] paramArrayOfByte, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfByte, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Character> slice(@NotNull char[] paramArrayOfChar, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Character.valueOf(paramArrayOfChar[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Character> slice(@NotNull char[] paramArrayOfChar, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfChar, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Double> slice(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Double.valueOf(paramArrayOfDouble[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Double> slice(@NotNull double[] paramArrayOfDouble, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfDouble, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Float> slice(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Float> slice(@NotNull float[] paramArrayOfFloat, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfFloat, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Integer> slice(@NotNull int[] paramArrayOfInt, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Integer> slice(@NotNull int[] paramArrayOfInt, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfInt, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Long> slice(@NotNull long[] paramArrayOfLong, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfLong[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Long> slice(@NotNull long[] paramArrayOfLong, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfLong, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final <T> List<T> slice(@NotNull T[] paramArrayOfT, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramArrayOfT[((Number)paramIterable.next()).intValue()]);
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> slice(@NotNull T[] paramArrayOfT, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfT, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Short> slice(@NotNull short[] paramArrayOfShort, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Short.valueOf(paramArrayOfShort[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Short> slice(@NotNull short[] paramArrayOfShort, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfShort, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final List<Boolean> slice(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[((Number)paramIterable.next()).intValue()]));
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Boolean> slice(@NotNull boolean[] paramArrayOfBoolean, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return ArraysKt.asList(ArraysKt.copyOfRange(paramArrayOfBoolean, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1));
  }
  
  @NotNull
  public static final byte[] sliceArray(@NotNull byte[] paramArrayOfByte, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    byte[] arrayOfByte = new byte[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfByte[i] = paramArrayOfByte[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static final byte[] sliceArray(@NotNull byte[] paramArrayOfByte, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new byte[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfByte, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final char[] sliceArray(@NotNull char[] paramArrayOfChar, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = paramArrayOfChar[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfChar;
  }
  
  @NotNull
  public static final char[] sliceArray(@NotNull char[] paramArrayOfChar, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new char[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfChar, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final double[] sliceArray(@NotNull double[] paramArrayOfDouble, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    double[] arrayOfDouble = new double[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfDouble[i] = paramArrayOfDouble[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public static final double[] sliceArray(@NotNull double[] paramArrayOfDouble, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new double[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfDouble, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final float[] sliceArray(@NotNull float[] paramArrayOfFloat, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    float[] arrayOfFloat = new float[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfFloat[i] = paramArrayOfFloat[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public static final float[] sliceArray(@NotNull float[] paramArrayOfFloat, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new float[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfFloat, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final int[] sliceArray(@NotNull int[] paramArrayOfInt, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfInt[i] = paramArrayOfInt[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfInt;
  }
  
  @NotNull
  public static final int[] sliceArray(@NotNull int[] paramArrayOfInt, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new int[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfInt, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final long[] sliceArray(@NotNull long[] paramArrayOfLong, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    long[] arrayOfLong = new long[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfLong[i] = paramArrayOfLong[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public static final long[] sliceArray(@NotNull long[] paramArrayOfLong, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new long[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfLong, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final <T> T[] sliceArray(@NotNull T[] paramArrayOfT, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    Object[] arrayOfObject = ArraysKt.arrayOfNulls(paramArrayOfT, paramCollection.size());
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfObject[i] = paramArrayOfT[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfObject;
  }
  
  @NotNull
  public static final <T> T[] sliceArray(@NotNull T[] paramArrayOfT, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return ArraysKt.copyOfRange(paramArrayOfT, 0, 0);
    }
    return ArraysKt.copyOfRange(paramArrayOfT, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final short[] sliceArray(@NotNull short[] paramArrayOfShort, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    short[] arrayOfShort = new short[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfShort[i] = paramArrayOfShort[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfShort;
  }
  
  @NotNull
  public static final short[] sliceArray(@NotNull short[] paramArrayOfShort, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new short[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfShort, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @NotNull
  public static final boolean[] sliceArray(@NotNull boolean[] paramArrayOfBoolean, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    boolean[] arrayOfBoolean = new boolean[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfBoolean[i] = paramArrayOfBoolean[((Number)paramCollection.next()).intValue()];
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  @NotNull
  public static final boolean[] sliceArray(@NotNull boolean[] paramArrayOfBoolean, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return new boolean[0];
    }
    return ArraysKt.copyOfRange(paramArrayOfBoolean, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfT.length > 1) {
      ArraysKt.sortWith(paramArrayOfT, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
    }
  }
  
  public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramArrayOfT.length > 1) {
      ArraysKt.sortWith(paramArrayOfT, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
    }
  }
  
  public static final void sortDescending(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortDescending");
    if (paramArrayOfByte.length > 1)
    {
      ArraysKt.sort(paramArrayOfByte);
      ArraysKt.reverse(paramArrayOfByte);
    }
  }
  
  public static final void sortDescending(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortDescending");
    if (paramArrayOfChar.length > 1)
    {
      ArraysKt.sort(paramArrayOfChar);
      ArraysKt.reverse(paramArrayOfChar);
    }
  }
  
  public static final void sortDescending(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortDescending");
    if (paramArrayOfDouble.length > 1)
    {
      ArraysKt.sort(paramArrayOfDouble);
      ArraysKt.reverse(paramArrayOfDouble);
    }
  }
  
  public static final void sortDescending(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortDescending");
    if (paramArrayOfFloat.length > 1)
    {
      ArraysKt.sort(paramArrayOfFloat);
      ArraysKt.reverse(paramArrayOfFloat);
    }
  }
  
  public static final void sortDescending(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortDescending");
    if (paramArrayOfInt.length > 1)
    {
      ArraysKt.sort(paramArrayOfInt);
      ArraysKt.reverse(paramArrayOfInt);
    }
  }
  
  public static final void sortDescending(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortDescending");
    if (paramArrayOfLong.length > 1)
    {
      ArraysKt.sort(paramArrayOfLong);
      ArraysKt.reverse(paramArrayOfLong);
    }
  }
  
  public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortDescending");
    ArraysKt.sortWith(paramArrayOfT, ComparisonsKt.reverseOrder());
  }
  
  public static final void sortDescending(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortDescending");
    if (paramArrayOfShort.length > 1)
    {
      ArraysKt.sort(paramArrayOfShort);
      ArraysKt.reverse(paramArrayOfShort);
    }
  }
  
  @NotNull
  public static final List<Byte> sorted(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sorted");
    paramArrayOfByte = ArraysKt.toTypedArray(paramArrayOfByte);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfByte;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfByte);
  }
  
  @NotNull
  public static final List<Character> sorted(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sorted");
    paramArrayOfChar = ArraysKt.toTypedArray(paramArrayOfChar);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfChar;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfChar);
  }
  
  @NotNull
  public static final List<Double> sorted(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sorted");
    paramArrayOfDouble = ArraysKt.toTypedArray(paramArrayOfDouble);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfDouble;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfDouble);
  }
  
  @NotNull
  public static final List<Float> sorted(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sorted");
    paramArrayOfFloat = ArraysKt.toTypedArray(paramArrayOfFloat);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfFloat;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfFloat);
  }
  
  @NotNull
  public static final List<Integer> sorted(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sorted");
    paramArrayOfInt = ArraysKt.toTypedArray(paramArrayOfInt);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfInt;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfInt);
  }
  
  @NotNull
  public static final List<Long> sorted(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sorted");
    paramArrayOfLong = ArraysKt.toTypedArray(paramArrayOfLong);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfLong;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfLong);
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sorted");
    return ArraysKt.asList(ArraysKt.sortedArray(paramArrayOfT));
  }
  
  @NotNull
  public static final List<Short> sorted(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sorted");
    paramArrayOfShort = ArraysKt.toTypedArray(paramArrayOfShort);
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfShort;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return ArraysKt.asList((Object[])paramArrayOfShort);
  }
  
  @NotNull
  public static final byte[] sortedArray(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedArray");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfByte;
    }
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final char[] sortedArray(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedArray");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfChar;
    }
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfChar);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final double[] sortedArray(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedArray");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfDouble);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final float[] sortedArray(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedArray");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final int[] sortedArray(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedArray");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfInt;
    }
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final long[] sortedArray(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedArray");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfLong;
    }
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T[] sortedArray(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedArray");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    Comparable[] arrayOfComparable = (Comparable[])paramArrayOfT;
    if (arrayOfComparable == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])arrayOfComparable);
    return (Comparable[])paramArrayOfT;
  }
  
  @NotNull
  public static final short[] sortedArray(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedArray");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfShort;
    }
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final byte[] sortedArrayDescending(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedArrayDescending");
    if (paramArrayOfByte.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfByte;
    }
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final char[] sortedArrayDescending(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedArrayDescending");
    if (paramArrayOfChar.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfChar;
    }
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfChar);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final double[] sortedArrayDescending(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedArrayDescending");
    if (paramArrayOfDouble.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfDouble);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final float[] sortedArrayDescending(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedArrayDescending");
    if (paramArrayOfFloat.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final int[] sortedArrayDescending(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedArrayDescending");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfInt;
    }
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final long[] sortedArrayDescending(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedArrayDescending");
    if (paramArrayOfLong.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfLong;
    }
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedArrayDescending");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortWith((Comparable[])paramArrayOfT, ComparisonsKt.reverseOrder());
    return (Comparable[])paramArrayOfT;
  }
  
  @NotNull
  public static final short[] sortedArrayDescending(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedArrayDescending");
    if (paramArrayOfShort.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfShort;
    }
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortDescending(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final <T> T[] sortedArrayWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedArrayWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sortWith(paramArrayOfT, paramComparator);
    return paramArrayOfT;
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Byte> sortedBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfByte, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Character> sortedBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfChar, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Double> sortedBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfDouble, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Float> sortedBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfFloat, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Integer> sortedBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfInt, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Long> sortedBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfLong, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfT, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Short> sortedBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfShort, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sortedBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfBoolean, (Comparator)new ComparisonsKt__ComparisonsKt.compareBy.2(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfByte, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfChar, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfDouble, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfFloat, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfInt, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfLong, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfT, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfShort, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sortedByDescending");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return ArraysKt.sortedWith(paramArrayOfBoolean, (Comparator)new ComparisonsKt__ComparisonsKt.compareByDescending.1(paramFunction1));
  }
  
  @NotNull
  public static final List<Byte> sortedDescending(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedDescending");
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfByte);
    return ArraysKt.reversed(paramArrayOfByte);
  }
  
  @NotNull
  public static final List<Character> sortedDescending(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedDescending");
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfChar);
    return ArraysKt.reversed(paramArrayOfChar);
  }
  
  @NotNull
  public static final List<Double> sortedDescending(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedDescending");
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfDouble);
    return ArraysKt.reversed(paramArrayOfDouble);
  }
  
  @NotNull
  public static final List<Float> sortedDescending(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedDescending");
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfFloat);
    return ArraysKt.reversed(paramArrayOfFloat);
  }
  
  @NotNull
  public static final List<Integer> sortedDescending(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedDescending");
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfInt);
    return ArraysKt.reversed(paramArrayOfInt);
  }
  
  @NotNull
  public static final List<Long> sortedDescending(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedDescending");
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfLong);
    return ArraysKt.reversed(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedDescending");
    return ArraysKt.sortedWith(paramArrayOfT, ComparisonsKt.reverseOrder());
  }
  
  @NotNull
  public static final List<Short> sortedDescending(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedDescending");
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    ArraysKt.sort(paramArrayOfShort);
    return ArraysKt.reversed(paramArrayOfShort);
  }
  
  @NotNull
  public static final List<Byte> sortedWith(@NotNull byte[] paramArrayOfByte, @NotNull Comparator<? super Byte> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfByte = ArraysKt.toTypedArray(paramArrayOfByte);
    ArraysKt.sortWith(paramArrayOfByte, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfByte);
  }
  
  @NotNull
  public static final List<Character> sortedWith(@NotNull char[] paramArrayOfChar, @NotNull Comparator<? super Character> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfChar = ArraysKt.toTypedArray(paramArrayOfChar);
    ArraysKt.sortWith(paramArrayOfChar, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfChar);
  }
  
  @NotNull
  public static final List<Double> sortedWith(@NotNull double[] paramArrayOfDouble, @NotNull Comparator<? super Double> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfDouble = ArraysKt.toTypedArray(paramArrayOfDouble);
    ArraysKt.sortWith(paramArrayOfDouble, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfDouble);
  }
  
  @NotNull
  public static final List<Float> sortedWith(@NotNull float[] paramArrayOfFloat, @NotNull Comparator<? super Float> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfFloat = ArraysKt.toTypedArray(paramArrayOfFloat);
    ArraysKt.sortWith(paramArrayOfFloat, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfFloat);
  }
  
  @NotNull
  public static final List<Integer> sortedWith(@NotNull int[] paramArrayOfInt, @NotNull Comparator<? super Integer> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfInt = ArraysKt.toTypedArray(paramArrayOfInt);
    ArraysKt.sortWith(paramArrayOfInt, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfInt);
  }
  
  @NotNull
  public static final List<Long> sortedWith(@NotNull long[] paramArrayOfLong, @NotNull Comparator<? super Long> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfLong = ArraysKt.toTypedArray(paramArrayOfLong);
    ArraysKt.sortWith(paramArrayOfLong, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> List<T> sortedWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return ArraysKt.asList(ArraysKt.sortedArrayWith(paramArrayOfT, paramComparator));
  }
  
  @NotNull
  public static final List<Short> sortedWith(@NotNull short[] paramArrayOfShort, @NotNull Comparator<? super Short> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfShort = ArraysKt.toTypedArray(paramArrayOfShort);
    ArraysKt.sortWith(paramArrayOfShort, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfShort);
  }
  
  @NotNull
  public static final List<Boolean> sortedWith(@NotNull boolean[] paramArrayOfBoolean, @NotNull Comparator<? super Boolean> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sortedWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    paramArrayOfBoolean = ArraysKt.toTypedArray(paramArrayOfBoolean);
    ArraysKt.sortWith(paramArrayOfBoolean, paramComparator);
    return ArraysKt.asList((Object[])paramArrayOfBoolean);
  }
  
  @NotNull
  public static final Set<Byte> subtract(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<Byte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfByte = ArraysKt.toMutableSet(paramArrayOfByte);
    CollectionsKt.removeAll((Collection)paramArrayOfByte, paramIterable);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final Set<Character> subtract(@NotNull char[] paramArrayOfChar, @NotNull Iterable<Character> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfChar = ArraysKt.toMutableSet(paramArrayOfChar);
    CollectionsKt.removeAll((Collection)paramArrayOfChar, paramIterable);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final Set<Double> subtract(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfDouble = ArraysKt.toMutableSet(paramArrayOfDouble);
    CollectionsKt.removeAll((Collection)paramArrayOfDouble, paramIterable);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final Set<Float> subtract(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfFloat = ArraysKt.toMutableSet(paramArrayOfFloat);
    CollectionsKt.removeAll((Collection)paramArrayOfFloat, paramIterable);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final Set<Integer> subtract(@NotNull int[] paramArrayOfInt, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfInt = ArraysKt.toMutableSet(paramArrayOfInt);
    CollectionsKt.removeAll((Collection)paramArrayOfInt, paramIterable);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final Set<Long> subtract(@NotNull long[] paramArrayOfLong, @NotNull Iterable<Long> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfLong = ArraysKt.toMutableSet(paramArrayOfLong);
    CollectionsKt.removeAll((Collection)paramArrayOfLong, paramIterable);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T> Set<T> subtract(@NotNull T[] paramArrayOfT, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfT = ArraysKt.toMutableSet(paramArrayOfT);
    CollectionsKt.removeAll((Collection)paramArrayOfT, paramIterable);
    return paramArrayOfT;
  }
  
  @NotNull
  public static final Set<Short> subtract(@NotNull short[] paramArrayOfShort, @NotNull Iterable<Short> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfShort = ArraysKt.toMutableSet(paramArrayOfShort);
    CollectionsKt.removeAll((Collection)paramArrayOfShort, paramIterable);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final Set<Boolean> subtract(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<Boolean> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$subtract");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfBoolean = ArraysKt.toMutableSet(paramArrayOfBoolean);
    CollectionsKt.removeAll((Collection)paramArrayOfBoolean, paramIterable);
    return paramArrayOfBoolean;
  }
  
  public static final double sum(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sum");
    double d = 0.0D;
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      d += paramArrayOfDouble[i];
      i += 1;
    }
    return d;
  }
  
  public static final float sum(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sum");
    float f = 0.0F;
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      f += paramArrayOfFloat[i];
      i += 1;
    }
    return f;
  }
  
  public static final int sum(@NotNull byte[] paramArrayOfByte)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sum");
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  public static final int sum(@NotNull int[] paramArrayOfInt)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sum");
    int k = paramArrayOfInt.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public static final int sum(@NotNull short[] paramArrayOfShort)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sum");
    int k = paramArrayOfShort.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfShort[i];
      i += 1;
    }
    return j;
  }
  
  public static final long sum(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sum");
    long l = 0L;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      l += paramArrayOfLong[i];
      i += 1;
    }
    return l;
  }
  
  public static final int sumBy(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfChar.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfDouble.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfFloat.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfLong.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final <T> int sumBy(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfT.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(paramArrayOfT[i])).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfShort.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final int sumBy(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int k = paramArrayOfBoolean.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final double sumByDouble(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final <T> double sumByDouble(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(paramArrayOfT[i])).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  public static final double sumByDouble(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @JvmName(name="sumOfByte")
  public static final int sumOfByte(@NotNull Byte[] paramArrayOfByte)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sum");
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfByte[i].byteValue();
      i += 1;
    }
    return j;
  }
  
  @JvmName(name="sumOfDouble")
  public static final double sumOfDouble(@NotNull Double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sum");
    double d = 0.0D;
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      d += paramArrayOfDouble[i].doubleValue();
      i += 1;
    }
    return d;
  }
  
  @JvmName(name="sumOfFloat")
  public static final float sumOfFloat(@NotNull Float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sum");
    float f = 0.0F;
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      f += paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    return f;
  }
  
  @JvmName(name="sumOfInt")
  public static final int sumOfInt(@NotNull Integer[] paramArrayOfInteger)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInteger, "$this$sum");
    int k = paramArrayOfInteger.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInteger[i].intValue();
      i += 1;
    }
    return j;
  }
  
  @JvmName(name="sumOfLong")
  public static final long sumOfLong(@NotNull Long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sum");
    long l = 0L;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      l += paramArrayOfLong[i].longValue();
      i += 1;
    }
    return l;
  }
  
  @JvmName(name="sumOfShort")
  public static final int sumOfShort(@NotNull Short[] paramArrayOfShort)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sum");
    int k = paramArrayOfShort.length;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfShort[i].shortValue();
      i += 1;
    }
    return j;
  }
  
  @NotNull
  public static final List<Byte> take(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfByte.length) {
      return ArraysKt.toList(paramArrayOfByte);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Byte.valueOf(paramArrayOfByte[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfByte.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Byte.valueOf(paramArrayOfByte[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Character> take(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfChar.length) {
      return ArraysKt.toList(paramArrayOfChar);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Character.valueOf(paramArrayOfChar[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfChar.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Character.valueOf(paramArrayOfChar[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Double> take(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfDouble.length) {
      return ArraysKt.toList(paramArrayOfDouble);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Double.valueOf(paramArrayOfDouble[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfDouble.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Double.valueOf(paramArrayOfDouble[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Float> take(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfFloat.length) {
      return ArraysKt.toList(paramArrayOfFloat);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Float.valueOf(paramArrayOfFloat[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfFloat.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Integer> take(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfInt.length) {
      return ArraysKt.toList(paramArrayOfInt);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Integer.valueOf(paramArrayOfInt[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfInt.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Long> take(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfLong.length) {
      return ArraysKt.toList(paramArrayOfLong);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Long.valueOf(paramArrayOfLong[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfLong.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final <T> List<T> take(@NotNull T[] paramArrayOfT, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfT.length) {
      return ArraysKt.toList(paramArrayOfT);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(paramArrayOfT[0]);
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfT.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(paramArrayOfT[i]);
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Short> take(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfShort.length) {
      return ArraysKt.toList(paramArrayOfShort);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Short.valueOf(paramArrayOfShort[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfShort.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Short.valueOf(paramArrayOfShort[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Boolean> take(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    if (paramInt >= paramArrayOfBoolean.length) {
      return ArraysKt.toList(paramArrayOfBoolean);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Boolean.valueOf(paramArrayOfBoolean[0]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfBoolean.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[i]));
        j += 1;
        if (j != paramInt) {}
      }
      else
      {
        return (List)localArrayList;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Byte> takeLast(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfByte.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfByte);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Byte.valueOf(paramArrayOfByte[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Byte.valueOf(paramArrayOfByte[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Character> takeLast(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfChar.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfChar);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Character.valueOf(paramArrayOfChar[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Character.valueOf(paramArrayOfChar[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Double> takeLast(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfDouble.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfDouble);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Double.valueOf(paramArrayOfDouble[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Double.valueOf(paramArrayOfDouble[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Float> takeLast(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfFloat.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfFloat);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Float.valueOf(paramArrayOfFloat[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Integer> takeLast(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfInt.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfInt);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Integer.valueOf(paramArrayOfInt[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Long> takeLast(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfLong.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfLong);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Long.valueOf(paramArrayOfLong[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> takeLast(@NotNull T[] paramArrayOfT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfT.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfT);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(paramArrayOfT[(i - 1)]);
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(paramArrayOfT[paramInt]);
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Short> takeLast(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfShort.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfShort);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Short.valueOf(paramArrayOfShort[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Short.valueOf(paramArrayOfShort[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Boolean> takeLast(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = paramArrayOfBoolean.length;
    if (paramInt >= i) {
      return ArraysKt.toList(paramArrayOfBoolean);
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(Boolean.valueOf(paramArrayOfBoolean[(i - 1)]));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[paramInt]));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Byte> takeLastWhile(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Byte.valueOf(paramArrayOfByte[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfByte, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfByte);
  }
  
  @NotNull
  public static final List<Character> takeLastWhile(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfChar);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramArrayOfChar[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfChar, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfChar);
  }
  
  @NotNull
  public static final List<Double> takeLastWhile(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfDouble);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Double.valueOf(paramArrayOfDouble[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfDouble, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfDouble);
  }
  
  @NotNull
  public static final List<Float> takeLastWhile(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfFloat);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Float.valueOf(paramArrayOfFloat[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfFloat, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfFloat);
  }
  
  @NotNull
  public static final List<Integer> takeLastWhile(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Integer.valueOf(paramArrayOfInt[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfInt, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfInt);
  }
  
  @NotNull
  public static final List<Long> takeLastWhile(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Long.valueOf(paramArrayOfLong[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfLong, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> List<T> takeLastWhile(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfT);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(paramArrayOfT[i])).booleanValue()) {
        return ArraysKt.drop(paramArrayOfT, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfT);
  }
  
  @NotNull
  public static final List<Short> takeLastWhile(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Short.valueOf(paramArrayOfShort[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfShort, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfShort);
  }
  
  @NotNull
  public static final List<Boolean> takeLastWhile(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = ArraysKt.getLastIndex(paramArrayOfBoolean);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Boolean.valueOf(paramArrayOfBoolean[i]))).booleanValue()) {
        return ArraysKt.drop(paramArrayOfBoolean, i + 1);
      }
      i -= 1;
    }
    return ArraysKt.toList(paramArrayOfBoolean);
  }
  
  @NotNull
  public static final List<Byte> takeWhile(@NotNull byte[] paramArrayOfByte, @NotNull Function1<? super Byte, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      byte b;
      if (i < j)
      {
        b = paramArrayOfByte[i];
        if (((Boolean)paramFunction1.invoke(Byte.valueOf(b))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Byte.valueOf(b));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Character> takeWhile(@NotNull char[] paramArrayOfChar, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      char c;
      if (i < j)
      {
        c = paramArrayOfChar[i];
        if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Character.valueOf(c));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Double> takeWhile(@NotNull double[] paramArrayOfDouble, @NotNull Function1<? super Double, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      double d;
      if (i < j)
      {
        d = paramArrayOfDouble[i];
        if (((Boolean)paramFunction1.invoke(Double.valueOf(d))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Double.valueOf(d));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Float> takeWhile(@NotNull float[] paramArrayOfFloat, @NotNull Function1<? super Float, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      float f;
      if (i < j)
      {
        f = paramArrayOfFloat[i];
        if (((Boolean)paramFunction1.invoke(Float.valueOf(f))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Float.valueOf(f));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Integer> takeWhile(@NotNull int[] paramArrayOfInt, @NotNull Function1<? super Integer, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j)
      {
        k = paramArrayOfInt[i];
        if (((Boolean)paramFunction1.invoke(Integer.valueOf(k))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Integer.valueOf(k));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Long> takeWhile(@NotNull long[] paramArrayOfLong, @NotNull Function1<? super Long, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      long l;
      if (i < j)
      {
        l = paramArrayOfLong[i];
        if (((Boolean)paramFunction1.invoke(Long.valueOf(l))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Long.valueOf(l));
      i += 1;
    }
  }
  
  @NotNull
  public static final <T> List<T> takeWhile(@NotNull T[] paramArrayOfT, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      T ?;
      if (i < j)
      {
        ? = paramArrayOfT[i];
        if (((Boolean)paramFunction1.invoke(?)).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(?);
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Short> takeWhile(@NotNull short[] paramArrayOfShort, @NotNull Function1<? super Short, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      short s;
      if (i < j)
      {
        s = paramArrayOfShort[i];
        if (((Boolean)paramFunction1.invoke(Short.valueOf(s))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Short.valueOf(s));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Boolean> takeWhile(@NotNull boolean[] paramArrayOfBoolean, @NotNull Function1<? super Boolean, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j)
      {
        k = paramArrayOfBoolean[i];
        if (((Boolean)paramFunction1.invoke(Boolean.valueOf(k))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(Boolean.valueOf(k));
      i += 1;
    }
  }
  
  @NotNull
  public static final boolean[] toBooleanArray(@NotNull Boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toBooleanArray");
    int j = paramArrayOfBoolean.length;
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBoolean[i] = paramArrayOfBoolean[i].booleanValue();
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  @NotNull
  public static final byte[] toByteArray(@NotNull Byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toByteArray");
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = paramArrayOfByte[i].byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static final char[] toCharArray(@NotNull Character[] paramArrayOfCharacter)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfCharacter, "$this$toCharArray");
    int j = paramArrayOfCharacter.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = paramArrayOfCharacter[i].charValue();
      i += 1;
    }
    return arrayOfChar;
  }
  
  @NotNull
  public static final <C extends Collection<? super Byte>> C toCollection(@NotNull byte[] paramArrayOfByte, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Character>> C toCollection(@NotNull char[] paramArrayOfChar, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Double>> C toCollection(@NotNull double[] paramArrayOfDouble, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Float>> C toCollection(@NotNull float[] paramArrayOfFloat, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Integer>> C toCollection(@NotNull int[] paramArrayOfInt, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Long>> C toCollection(@NotNull long[] paramArrayOfLong, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <T, C extends Collection<? super T>> C toCollection(@NotNull T[] paramArrayOfT, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramArrayOfT[i]);
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Short>> C toCollection(@NotNull short[] paramArrayOfShort, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Collection<? super Boolean>> C toCollection(@NotNull boolean[] paramArrayOfBoolean, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final double[] toDoubleArray(@NotNull Double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toDoubleArray");
    int j = paramArrayOfDouble.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramArrayOfDouble[i].doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public static final float[] toFloatArray(@NotNull Float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toFloatArray");
    int j = paramArrayOfFloat.length;
    float[] arrayOfFloat = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public static final HashSet<Byte> toHashSet(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfByte, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfByte.length)));
  }
  
  @NotNull
  public static final HashSet<Character> toHashSet(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfChar, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfChar.length)));
  }
  
  @NotNull
  public static final HashSet<Double> toHashSet(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfDouble, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfDouble.length)));
  }
  
  @NotNull
  public static final HashSet<Float> toHashSet(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfFloat, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfFloat.length)));
  }
  
  @NotNull
  public static final HashSet<Integer> toHashSet(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfInt, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfInt.length)));
  }
  
  @NotNull
  public static final HashSet<Long> toHashSet(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfLong, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfLong.length)));
  }
  
  @NotNull
  public static final <T> HashSet<T> toHashSet(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfT, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfT.length)));
  }
  
  @NotNull
  public static final HashSet<Short> toHashSet(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfShort, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfShort.length)));
  }
  
  @NotNull
  public static final HashSet<Boolean> toHashSet(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toHashSet");
    return (HashSet)ArraysKt.toCollection(paramArrayOfBoolean, (Collection)new HashSet(MapsKt.mapCapacity(paramArrayOfBoolean.length)));
  }
  
  @NotNull
  public static final int[] toIntArray(@NotNull Integer[] paramArrayOfInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInteger, "$this$toIntArray");
    int j = paramArrayOfInteger.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  @NotNull
  public static final List<Byte> toList(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toList");
    switch (paramArrayOfByte.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfByte);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Byte.valueOf(paramArrayOfByte[0]));
  }
  
  @NotNull
  public static final List<Character> toList(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toList");
    switch (paramArrayOfChar.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfChar);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Character.valueOf(paramArrayOfChar[0]));
  }
  
  @NotNull
  public static final List<Double> toList(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toList");
    switch (paramArrayOfDouble.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfDouble);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Double.valueOf(paramArrayOfDouble[0]));
  }
  
  @NotNull
  public static final List<Float> toList(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toList");
    switch (paramArrayOfFloat.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfFloat);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Float.valueOf(paramArrayOfFloat[0]));
  }
  
  @NotNull
  public static final List<Integer> toList(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toList");
    switch (paramArrayOfInt.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfInt);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Integer.valueOf(paramArrayOfInt[0]));
  }
  
  @NotNull
  public static final List<Long> toList(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toList");
    switch (paramArrayOfLong.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfLong);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Long.valueOf(paramArrayOfLong[0]));
  }
  
  @NotNull
  public static final <T> List<T> toList(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toList");
    switch (paramArrayOfT.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfT);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(paramArrayOfT[0]);
  }
  
  @NotNull
  public static final List<Short> toList(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toList");
    switch (paramArrayOfShort.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfShort);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Short.valueOf(paramArrayOfShort[0]));
  }
  
  @NotNull
  public static final List<Boolean> toList(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toList");
    switch (paramArrayOfBoolean.length)
    {
    default: 
      return ArraysKt.toMutableList(paramArrayOfBoolean);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Boolean.valueOf(paramArrayOfBoolean[0]));
  }
  
  @NotNull
  public static final long[] toLongArray(@NotNull Long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toLongArray");
    int j = paramArrayOfLong.length;
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = paramArrayOfLong[i].longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public static final List<Byte> toMutableList(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Character> toMutableList(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfChar.length);
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Double> toMutableList(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfDouble.length);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Float> toMutableList(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Integer> toMutableList(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Long> toMutableList(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T> List<T> toMutableList(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toMutableList");
    return (List)new ArrayList(CollectionsKt.asCollection(paramArrayOfT));
  }
  
  @NotNull
  public static final List<Short> toMutableList(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfShort.length);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Boolean> toMutableList(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfBoolean.length);
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final Set<Byte> toMutableSet(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfByte.length));
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Character> toMutableSet(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfChar.length));
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Double> toMutableSet(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfDouble.length));
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Float> toMutableSet(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfFloat.length));
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Integer> toMutableSet(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfInt.length));
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Long> toMutableSet(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfLong.length));
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final <T> Set<T> toMutableSet(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfT.length));
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(paramArrayOfT[i]);
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Short> toMutableSet(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfShort.length));
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Boolean> toMutableSet(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toMutableSet");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfBoolean.length));
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      localLinkedHashSet.add(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
    }
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final Set<Byte> toSet(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toSet");
    switch (paramArrayOfByte.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfByte, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfByte.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Byte.valueOf(paramArrayOfByte[0]));
  }
  
  @NotNull
  public static final Set<Character> toSet(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toSet");
    switch (paramArrayOfChar.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfChar, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfChar.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Character.valueOf(paramArrayOfChar[0]));
  }
  
  @NotNull
  public static final Set<Double> toSet(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toSet");
    switch (paramArrayOfDouble.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfDouble, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfDouble.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Double.valueOf(paramArrayOfDouble[0]));
  }
  
  @NotNull
  public static final Set<Float> toSet(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toSet");
    switch (paramArrayOfFloat.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfFloat, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfFloat.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Float.valueOf(paramArrayOfFloat[0]));
  }
  
  @NotNull
  public static final Set<Integer> toSet(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toSet");
    switch (paramArrayOfInt.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfInt, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfInt.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Integer.valueOf(paramArrayOfInt[0]));
  }
  
  @NotNull
  public static final Set<Long> toSet(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toSet");
    switch (paramArrayOfLong.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfLong, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfLong.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Long.valueOf(paramArrayOfLong[0]));
  }
  
  @NotNull
  public static final <T> Set<T> toSet(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toSet");
    switch (paramArrayOfT.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfT, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfT.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(paramArrayOfT[0]);
  }
  
  @NotNull
  public static final Set<Short> toSet(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toSet");
    switch (paramArrayOfShort.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfShort, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfShort.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Short.valueOf(paramArrayOfShort[0]));
  }
  
  @NotNull
  public static final Set<Boolean> toSet(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toSet");
    switch (paramArrayOfBoolean.length)
    {
    default: 
      return (Set)ArraysKt.toCollection(paramArrayOfBoolean, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramArrayOfBoolean.length)));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Boolean.valueOf(paramArrayOfBoolean[0]));
  }
  
  @NotNull
  public static final short[] toShortArray(@NotNull Short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toShortArray");
    int j = paramArrayOfShort.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = paramArrayOfShort[i].shortValue();
      i += 1;
    }
    return arrayOfShort;
  }
  
  @NotNull
  public static final Set<Byte> union(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<Byte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfByte = ArraysKt.toMutableSet(paramArrayOfByte);
    CollectionsKt.addAll((Collection)paramArrayOfByte, paramIterable);
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final Set<Character> union(@NotNull char[] paramArrayOfChar, @NotNull Iterable<Character> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfChar = ArraysKt.toMutableSet(paramArrayOfChar);
    CollectionsKt.addAll((Collection)paramArrayOfChar, paramIterable);
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final Set<Double> union(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<Double> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfDouble = ArraysKt.toMutableSet(paramArrayOfDouble);
    CollectionsKt.addAll((Collection)paramArrayOfDouble, paramIterable);
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final Set<Float> union(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<Float> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfFloat = ArraysKt.toMutableSet(paramArrayOfFloat);
    CollectionsKt.addAll((Collection)paramArrayOfFloat, paramIterable);
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final Set<Integer> union(@NotNull int[] paramArrayOfInt, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfInt = ArraysKt.toMutableSet(paramArrayOfInt);
    CollectionsKt.addAll((Collection)paramArrayOfInt, paramIterable);
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final Set<Long> union(@NotNull long[] paramArrayOfLong, @NotNull Iterable<Long> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfLong = ArraysKt.toMutableSet(paramArrayOfLong);
    CollectionsKt.addAll((Collection)paramArrayOfLong, paramIterable);
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final <T> Set<T> union(@NotNull T[] paramArrayOfT, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfT = ArraysKt.toMutableSet(paramArrayOfT);
    CollectionsKt.addAll((Collection)paramArrayOfT, paramIterable);
    return paramArrayOfT;
  }
  
  @NotNull
  public static final Set<Short> union(@NotNull short[] paramArrayOfShort, @NotNull Iterable<Short> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfShort = ArraysKt.toMutableSet(paramArrayOfShort);
    CollectionsKt.addAll((Collection)paramArrayOfShort, paramIterable);
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final Set<Boolean> union(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<Boolean> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$union");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    paramArrayOfBoolean = ArraysKt.toMutableSet(paramArrayOfBoolean);
    CollectionsKt.addAll((Collection)paramArrayOfBoolean, paramIterable);
    return paramArrayOfBoolean;
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Byte>> withIndex(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.2(paramArrayOfByte));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Character>> withIndex(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.9(paramArrayOfChar));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Double>> withIndex(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.7(paramArrayOfDouble));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Float>> withIndex(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.6(paramArrayOfFloat));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Integer>> withIndex(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.4(paramArrayOfInt));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Long>> withIndex(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.5(paramArrayOfLong));
  }
  
  @NotNull
  public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.1(paramArrayOfT));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Short>> withIndex(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.3(paramArrayOfShort));
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Boolean>> withIndex(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new ArraysKt___ArraysKt.withIndex.8(paramArrayOfBoolean));
  }
  
  @NotNull
  public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfByte.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Byte.valueOf(paramArrayOfByte[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Byte, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfByte.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Byte.valueOf(paramArrayOfByte[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Byte, Byte>> zip(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Byte.valueOf(paramArrayOfByte1[i]), Byte.valueOf(paramArrayOfByte2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2, @NotNull Function2<? super Byte, ? super Byte, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Byte.valueOf(paramArrayOfByte1[i]), Byte.valueOf(paramArrayOfByte2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] paramArrayOfByte, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfByte.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Byte.valueOf(paramArrayOfByte[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull byte[] paramArrayOfByte, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Byte, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfByte.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Byte.valueOf(paramArrayOfByte[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Character, R>> zip(@NotNull char[] paramArrayOfChar, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfChar.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Character.valueOf(paramArrayOfChar[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull char[] paramArrayOfChar, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Character, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfChar.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramArrayOfChar[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Character, Character>> zip(@NotNull char[] paramArrayOfChar1, @NotNull char[] paramArrayOfChar2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "other");
    int j = Math.min(paramArrayOfChar1.length, paramArrayOfChar2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Character.valueOf(paramArrayOfChar1[i]), Character.valueOf(paramArrayOfChar2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull char[] paramArrayOfChar1, @NotNull char[] paramArrayOfChar2, @NotNull Function2<? super Character, ? super Character, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfChar1.length, paramArrayOfChar2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramArrayOfChar1[i]), Character.valueOf(paramArrayOfChar2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Character, R>> zip(@NotNull char[] paramArrayOfChar, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfChar.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Character.valueOf(paramArrayOfChar[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull char[] paramArrayOfChar, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Character, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfChar.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramArrayOfChar[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Double, R>> zip(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfDouble.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Double.valueOf(paramArrayOfDouble[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull double[] paramArrayOfDouble, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Double, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfDouble.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Double.valueOf(paramArrayOfDouble[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Double, Double>> zip(@NotNull double[] paramArrayOfDouble1, @NotNull double[] paramArrayOfDouble2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "other");
    int j = Math.min(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Double.valueOf(paramArrayOfDouble1[i]), Double.valueOf(paramArrayOfDouble2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull double[] paramArrayOfDouble1, @NotNull double[] paramArrayOfDouble2, @NotNull Function2<? super Double, ? super Double, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Double.valueOf(paramArrayOfDouble1[i]), Double.valueOf(paramArrayOfDouble2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Double, R>> zip(@NotNull double[] paramArrayOfDouble, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfDouble.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Double.valueOf(paramArrayOfDouble[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull double[] paramArrayOfDouble, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Double, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfDouble.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Double.valueOf(paramArrayOfDouble[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Float, R>> zip(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfFloat.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Float.valueOf(paramArrayOfFloat[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull float[] paramArrayOfFloat, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Float, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfFloat.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Float.valueOf(paramArrayOfFloat[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Float, Float>> zip(@NotNull float[] paramArrayOfFloat1, @NotNull float[] paramArrayOfFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "other");
    int j = Math.min(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Float.valueOf(paramArrayOfFloat1[i]), Float.valueOf(paramArrayOfFloat2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull float[] paramArrayOfFloat1, @NotNull float[] paramArrayOfFloat2, @NotNull Function2<? super Float, ? super Float, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Float.valueOf(paramArrayOfFloat1[i]), Float.valueOf(paramArrayOfFloat2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Float, R>> zip(@NotNull float[] paramArrayOfFloat, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfFloat.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Float.valueOf(paramArrayOfFloat[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull float[] paramArrayOfFloat, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Float, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfFloat.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Float.valueOf(paramArrayOfFloat[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] paramArrayOfInt, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfInt.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Integer.valueOf(paramArrayOfInt[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull int[] paramArrayOfInt, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Integer, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfInt.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Integer.valueOf(paramArrayOfInt[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Integer, Integer>> zip(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    int j = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Integer.valueOf(paramArrayOfInt1[i]), Integer.valueOf(paramArrayOfInt2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2, @NotNull Function2<? super Integer, ? super Integer, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Integer.valueOf(paramArrayOfInt1[i]), Integer.valueOf(paramArrayOfInt2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] paramArrayOfInt, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfInt.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Integer.valueOf(paramArrayOfInt[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull int[] paramArrayOfInt, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Integer, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfInt.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Integer.valueOf(paramArrayOfInt[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Long, R>> zip(@NotNull long[] paramArrayOfLong, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfLong.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Long.valueOf(paramArrayOfLong[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull long[] paramArrayOfLong, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Long, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfLong.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Long.valueOf(paramArrayOfLong[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final List<Pair<Long, Long>> zip(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    int j = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Long.valueOf(paramArrayOfLong1[i]), Long.valueOf(paramArrayOfLong2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2, @NotNull Function2<? super Long, ? super Long, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Long.valueOf(paramArrayOfLong1[i]), Long.valueOf(paramArrayOfLong2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Long, R>> zip(@NotNull long[] paramArrayOfLong, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfLong.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Long.valueOf(paramArrayOfLong[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull long[] paramArrayOfLong, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Long, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfLong.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Long.valueOf(paramArrayOfLong[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] paramArrayOfT, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(paramArrayOfT[i], localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <T, R, V> List<V> zip(@NotNull T[] paramArrayOfT, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(paramArrayOfT[i], localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] paramArrayOfT, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfT.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(paramArrayOfT[i], paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <T, R, V> List<V> zip(@NotNull T[] paramArrayOfT, @NotNull R[] paramArrayOfR, @NotNull Function2<? super T, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfT.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(paramArrayOfT[i], paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Short, R>> zip(@NotNull short[] paramArrayOfShort, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfShort.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Short.valueOf(paramArrayOfShort[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull short[] paramArrayOfShort, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Short, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfShort.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Short.valueOf(paramArrayOfShort[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R> List<Pair<Short, R>> zip(@NotNull short[] paramArrayOfShort, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfShort.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Short.valueOf(paramArrayOfShort[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull short[] paramArrayOfShort, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Short, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfShort.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Short.valueOf(paramArrayOfShort[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Pair<Short, Short>> zip(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    int j = Math.min(paramArrayOfShort1.length, paramArrayOfShort2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Short.valueOf(paramArrayOfShort1[i]), Short.valueOf(paramArrayOfShort2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2, @NotNull Function2<? super Short, ? super Short, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfShort1.length, paramArrayOfShort2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Short.valueOf(paramArrayOfShort1[i]), Short.valueOf(paramArrayOfShort2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = paramArrayOfBoolean.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(TuplesKt.to(Boolean.valueOf(paramArrayOfBoolean[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull boolean[] paramArrayOfBoolean, @NotNull Iterable<? extends R> paramIterable, @NotNull Function2<? super Boolean, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramArrayOfBoolean.length;
    ArrayList localArrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(paramIterable, 10), j));
    int i = 0;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      Object localObject;
      if (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (i < j) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean[i]), localObject));
      i += 1;
    }
  }
  
  @NotNull
  public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] paramArrayOfBoolean, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(paramArrayOfBoolean.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Boolean.valueOf(paramArrayOfBoolean[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <R, V> List<V> zip(@NotNull boolean[] paramArrayOfBoolean, @NotNull R[] paramArrayOfR, @NotNull Function2<? super Boolean, ? super R, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfBoolean.length, paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean[i]), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final List<Pair<Boolean, Boolean>> zip(@NotNull boolean[] paramArrayOfBoolean1, @NotNull boolean[] paramArrayOfBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "other");
    int j = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Boolean.valueOf(paramArrayOfBoolean1[i]), Boolean.valueOf(paramArrayOfBoolean2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull boolean[] paramArrayOfBoolean1, @NotNull boolean[] paramArrayOfBoolean2, @NotNull Function2<? super Boolean, ? super Boolean, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Boolean.valueOf(paramArrayOfBoolean1[i]), Boolean.valueOf(paramArrayOfBoolean2[i])));
      i += 1;
    }
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt
 * JD-Core Version:    0.7.0.1
 */