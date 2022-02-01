package kotlin.collections.unsigned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.UArraySortingKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"indices", "Lkotlin/ranges/IntRange;", "Lkotlin/UByteArray;", "indices$annotations", "([B)V", "getIndices-GBYM_sE", "([B)Lkotlin/ranges/IntRange;", "Lkotlin/UIntArray;", "([I)V", "getIndices--ajY-9A", "([I)Lkotlin/ranges/IntRange;", "Lkotlin/ULongArray;", "([J)V", "getIndices-QwZRm1k", "([J)Lkotlin/ranges/IntRange;", "Lkotlin/UShortArray;", "([S)V", "getIndices-rL5Bavg", "([S)Lkotlin/ranges/IntRange;", "lastIndex", "", "lastIndex$annotations", "getLastIndex-GBYM_sE", "([B)I", "getLastIndex--ajY-9A", "([I)I", "getLastIndex-QwZRm1k", "([J)I", "getLastIndex-rL5Bavg", "([S)I", "all", "", "predicate", "Lkotlin/Function1;", "Lkotlin/UByte;", "all-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Z", "Lkotlin/UInt;", "all-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Z", "Lkotlin/ULong;", "all-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Z", "Lkotlin/UShort;", "all-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Z", "any", "any-GBYM_sE", "([B)Z", "any-JOV_ifY", "any--ajY-9A", "([I)Z", "any-jgv0xPQ", "any-QwZRm1k", "([J)Z", "any-MShoTSo", "any-rL5Bavg", "([S)Z", "any-xTcfx_M", "asByteArray", "", "asByteArray-GBYM_sE", "([B)[B", "asIntArray", "", "asIntArray--ajY-9A", "([I)[I", "asLongArray", "", "asLongArray-QwZRm1k", "([J)[J", "asShortArray", "", "asShortArray-rL5Bavg", "([S)[S", "asUByteArray", "asUIntArray", "asULongArray", "asUShortArray", "component1", "component1-GBYM_sE", "([B)B", "component1--ajY-9A", "component1-QwZRm1k", "([J)J", "component1-rL5Bavg", "([S)S", "component2", "component2-GBYM_sE", "component2--ajY-9A", "component2-QwZRm1k", "component2-rL5Bavg", "component3", "component3-GBYM_sE", "component3--ajY-9A", "component3-QwZRm1k", "component3-rL5Bavg", "component4", "component4-GBYM_sE", "component4--ajY-9A", "component4-QwZRm1k", "component4-rL5Bavg", "component5", "component5-GBYM_sE", "component5--ajY-9A", "component5-QwZRm1k", "component5-rL5Bavg", "contentEquals", "other", "contentEquals-kdPth3s", "([B[B)Z", "contentEquals-ctEhBpI", "([I[I)Z", "contentEquals-us8wMrg", "([J[J)Z", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "contentHashCode-GBYM_sE", "contentHashCode--ajY-9A", "contentHashCode-QwZRm1k", "contentHashCode-rL5Bavg", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "copyInto-FUQE5sA", "([B[BIII)[B", "copyInto-sIZ3KeM", "([I[IIII)[I", "copyInto--B0-L2c", "([J[JIII)[J", "copyInto-9-ak10g", "([S[SIII)[S", "copyOf", "copyOf-GBYM_sE", "newSize", "copyOf-PpDY95g", "([BI)[B", "copyOf--ajY-9A", "copyOf-qFRl0hI", "([II)[I", "copyOf-QwZRm1k", "copyOf-r7IrZao", "([JI)[J", "copyOf-rL5Bavg", "copyOf-nggk6HY", "([SI)[S", "copyOfRange", "fromIndex", "toIndex", "copyOfRange-4UcCI2c", "([BII)[B", "copyOfRange-oBK06Vg", "([III)[I", "copyOfRange--nroSd4", "([JII)[J", "copyOfRange-Aa5vz7o", "([SII)[S", "count", "count-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)I", "count-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)I", "count-MShoTSo", "([JLkotlin/jvm/functions/Function1;)I", "count-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)I", "drop", "", "n", "drop-PpDY95g", "([BI)Ljava/util/List;", "drop-qFRl0hI", "([II)Ljava/util/List;", "drop-r7IrZao", "([JI)Ljava/util/List;", "drop-nggk6HY", "([SI)Ljava/util/List;", "dropLast", "dropLast-PpDY95g", "dropLast-qFRl0hI", "dropLast-r7IrZao", "dropLast-nggk6HY", "dropLastWhile", "dropLastWhile-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Ljava/util/List;", "dropLastWhile-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "dropLastWhile-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Ljava/util/List;", "dropLastWhile-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Ljava/util/List;", "dropWhile", "dropWhile-JOV_ifY", "dropWhile-jgv0xPQ", "dropWhile-MShoTSo", "dropWhile-xTcfx_M", "elementAtOrElse", "index", "defaultValue", "elementAtOrElse-cO-VybQ", "([BILkotlin/jvm/functions/Function1;)B", "elementAtOrElse-QxvSvLU", "([IILkotlin/jvm/functions/Function1;)I", "elementAtOrElse-Xw8i6dc", "([JILkotlin/jvm/functions/Function1;)J", "elementAtOrElse-CVVdw08", "([SILkotlin/jvm/functions/Function1;)S", "elementAtOrNull", "elementAtOrNull-PpDY95g", "([BI)Lkotlin/UByte;", "elementAtOrNull-qFRl0hI", "([II)Lkotlin/UInt;", "elementAtOrNull-r7IrZao", "([JI)Lkotlin/ULong;", "elementAtOrNull-nggk6HY", "([SI)Lkotlin/UShort;", "fill", "", "element", "fill-WpHrYlw", "([BBII)V", "fill-2fe2U9s", "([IIII)V", "fill-K6DWlUc", "([JJII)V", "fill-EtDCXyQ", "([SSII)V", "filter", "filter-JOV_ifY", "filter-jgv0xPQ", "filter-MShoTSo", "filter-xTcfx_M", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexed-ELGow60", "([BLkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexed-WyvcNBI", "([ILkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexed-s8dVfGU", "([JLkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexed-xzaTVY8", "([SLkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexedTo", "C", "", "filterIndexedTo-eNpIKz8", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIndexedTo--6EtJGI", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIndexedTo-pe2Q0Dw", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIndexedTo-QqktQ3k", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterNot", "filterNot-JOV_ifY", "filterNot-jgv0xPQ", "filterNot-MShoTSo", "filterNot-xTcfx_M", "filterNotTo", "filterNotTo-wzUQCXU", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterNotTo-wU5IKMo", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterNotTo-HqK1JgA", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterNotTo-oEOeDjA", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "filterTo-wzUQCXU", "filterTo-wU5IKMo", "filterTo-HqK1JgA", "filterTo-oEOeDjA", "find", "find-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "find-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "find-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "find-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "findLast", "findLast-JOV_ifY", "findLast-jgv0xPQ", "findLast-MShoTSo", "findLast-xTcfx_M", "first", "first-GBYM_sE", "first-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)B", "first--ajY-9A", "first-jgv0xPQ", "first-QwZRm1k", "first-MShoTSo", "([JLkotlin/jvm/functions/Function1;)J", "first-rL5Bavg", "first-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)S", "firstOrNull", "firstOrNull-GBYM_sE", "([B)Lkotlin/UByte;", "firstOrNull-JOV_ifY", "firstOrNull--ajY-9A", "([I)Lkotlin/UInt;", "firstOrNull-jgv0xPQ", "firstOrNull-QwZRm1k", "([J)Lkotlin/ULong;", "firstOrNull-MShoTSo", "firstOrNull-rL5Bavg", "([S)Lkotlin/UShort;", "firstOrNull-xTcfx_M", "flatMap", "R", "transform", "", "flatMap-JOV_ifY", "flatMap-jgv0xPQ", "flatMap-MShoTSo", "flatMap-xTcfx_M", "flatMapTo", "flatMapTo-wzUQCXU", "flatMapTo-wU5IKMo", "flatMapTo-HqK1JgA", "flatMapTo-oEOeDjA", "fold", "initial", "operation", "acc", "fold-yXmHNn8", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fold-zi1B2BA", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fold-A8wKCXQ", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fold-zww5nb8", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "foldIndexed-3iWJZGE", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldIndexed-yVwIW0Q", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldIndexed-mwnnOCs", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldIndexed-bzxtMww", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRight-yXmHNn8", "foldRight-zi1B2BA", "foldRight-A8wKCXQ", "foldRight-zww5nb8", "foldRightIndexed", "foldRightIndexed-3iWJZGE", "foldRightIndexed-yVwIW0Q", "foldRightIndexed-mwnnOCs", "foldRightIndexed-bzxtMww", "forEach", "action", "forEach-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)V", "forEach-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)V", "forEach-MShoTSo", "([JLkotlin/jvm/functions/Function1;)V", "forEach-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)V", "forEachIndexed", "forEachIndexed-ELGow60", "([BLkotlin/jvm/functions/Function2;)V", "forEachIndexed-WyvcNBI", "([ILkotlin/jvm/functions/Function2;)V", "forEachIndexed-s8dVfGU", "([JLkotlin/jvm/functions/Function2;)V", "forEachIndexed-xzaTVY8", "([SLkotlin/jvm/functions/Function2;)V", "getOrElse", "getOrElse-cO-VybQ", "getOrElse-QxvSvLU", "getOrElse-Xw8i6dc", "getOrElse-CVVdw08", "getOrNull", "getOrNull-PpDY95g", "getOrNull-qFRl0hI", "getOrNull-r7IrZao", "getOrNull-nggk6HY", "groupBy", "", "K", "keySelector", "groupBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Ljava/util/Map;", "V", "valueTransform", "groupBy-bBsjw1Y", "([BLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy-L4rlFek", "([ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy--_j2Y-Q", "([JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupBy-3bBvP4M", "([SLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo", "M", "", "", "groupByTo-H21X9dk", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-qOZmbk8", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-4D70W2E", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-JM6gNCM", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-X6OPwNk", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-QxgOkWg", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-ciTST-8", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "groupByTo-q8RuPII", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "indexOf", "indexOf-gMuBH34", "([BB)I", "indexOf-uWY9BYg", "([II)I", "indexOf-3uqUaXg", "([JJ)I", "indexOf-XzdR7RA", "([SS)I", "indexOfFirst", "indexOfFirst-JOV_ifY", "indexOfFirst-jgv0xPQ", "indexOfFirst-MShoTSo", "indexOfFirst-xTcfx_M", "indexOfLast", "indexOfLast-JOV_ifY", "indexOfLast-jgv0xPQ", "indexOfLast-MShoTSo", "indexOfLast-xTcfx_M", "last", "last-GBYM_sE", "last-JOV_ifY", "last--ajY-9A", "last-jgv0xPQ", "last-QwZRm1k", "last-MShoTSo", "last-rL5Bavg", "last-xTcfx_M", "lastIndexOf", "lastIndexOf-gMuBH34", "lastIndexOf-uWY9BYg", "lastIndexOf-3uqUaXg", "lastIndexOf-XzdR7RA", "lastOrNull", "lastOrNull-GBYM_sE", "lastOrNull-JOV_ifY", "lastOrNull--ajY-9A", "lastOrNull-jgv0xPQ", "lastOrNull-QwZRm1k", "lastOrNull-MShoTSo", "lastOrNull-rL5Bavg", "lastOrNull-xTcfx_M", "map", "map-JOV_ifY", "map-jgv0xPQ", "map-MShoTSo", "map-xTcfx_M", "mapIndexed", "mapIndexed-ELGow60", "mapIndexed-WyvcNBI", "mapIndexed-s8dVfGU", "mapIndexed-xzaTVY8", "mapIndexedTo", "mapIndexedTo-eNpIKz8", "mapIndexedTo--6EtJGI", "mapIndexedTo-pe2Q0Dw", "mapIndexedTo-QqktQ3k", "mapTo", "mapTo-wzUQCXU", "mapTo-wU5IKMo", "mapTo-HqK1JgA", "mapTo-oEOeDjA", "max", "max-GBYM_sE", "max--ajY-9A", "max-QwZRm1k", "max-rL5Bavg", "maxBy", "", "selector", "maxBy-JOV_ifY", "maxBy-jgv0xPQ", "maxBy-MShoTSo", "maxBy-xTcfx_M", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "none", "none-GBYM_sE", "none-JOV_ifY", "none--ajY-9A", "none-jgv0xPQ", "none-QwZRm1k", "none-MShoTSo", "none-rL5Bavg", "none-xTcfx_M", "plus", "plus-gMuBH34", "([BB)[B", "elements", "plus-kdPth3s", "([B[B)[B", "", "plus-xo_DsdI", "([BLjava/util/Collection;)[B", "plus-uWY9BYg", "plus-ctEhBpI", "([I[I)[I", "plus-CFIt9YE", "([ILjava/util/Collection;)[I", "plus-3uqUaXg", "([JJ)[J", "plus-us8wMrg", "([J[J)[J", "plus-kzHmqpY", "([JLjava/util/Collection;)[J", "plus-XzdR7RA", "([SS)[S", "plus-mazbYpA", "([S[S)[S", "plus-ojwP5H8", "([SLjava/util/Collection;)[S", "random", "random-GBYM_sE", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "random--ajY-9A", "random-2D5oskM", "([ILkotlin/random/Random;)I", "random-QwZRm1k", "random-JzugnMA", "([JLkotlin/random/Random;)J", "random-rL5Bavg", "random-s5X_as8", "([SLkotlin/random/Random;)S", "randomOrNull", "randomOrNull-GBYM_sE", "randomOrNull-oSF2wD8", "([BLkotlin/random/Random;)Lkotlin/UByte;", "randomOrNull--ajY-9A", "randomOrNull-2D5oskM", "([ILkotlin/random/Random;)Lkotlin/UInt;", "randomOrNull-QwZRm1k", "randomOrNull-JzugnMA", "([JLkotlin/random/Random;)Lkotlin/ULong;", "randomOrNull-rL5Bavg", "randomOrNull-s5X_as8", "([SLkotlin/random/Random;)Lkotlin/UShort;", "reduce", "reduce-ELGow60", "([BLkotlin/jvm/functions/Function2;)B", "reduce-WyvcNBI", "([ILkotlin/jvm/functions/Function2;)I", "reduce-s8dVfGU", "([JLkotlin/jvm/functions/Function2;)J", "reduce-xzaTVY8", "([SLkotlin/jvm/functions/Function2;)S", "reduceIndexed", "reduceIndexed-EOyYB1Y", "([BLkotlin/jvm/functions/Function3;)B", "reduceIndexed-D40WMg8", "([ILkotlin/jvm/functions/Function3;)I", "reduceIndexed-z1zDJgo", "([JLkotlin/jvm/functions/Function3;)J", "reduceIndexed-aLgx1Fo", "([SLkotlin/jvm/functions/Function3;)S", "reduceOrNull", "reduceOrNull-ELGow60", "([BLkotlin/jvm/functions/Function2;)Lkotlin/UByte;", "reduceOrNull-WyvcNBI", "([ILkotlin/jvm/functions/Function2;)Lkotlin/UInt;", "reduceOrNull-s8dVfGU", "([JLkotlin/jvm/functions/Function2;)Lkotlin/ULong;", "reduceOrNull-xzaTVY8", "([SLkotlin/jvm/functions/Function2;)Lkotlin/UShort;", "reduceRight", "reduceRight-ELGow60", "reduceRight-WyvcNBI", "reduceRight-s8dVfGU", "reduceRight-xzaTVY8", "reduceRightIndexed", "reduceRightIndexed-EOyYB1Y", "reduceRightIndexed-D40WMg8", "reduceRightIndexed-z1zDJgo", "reduceRightIndexed-aLgx1Fo", "reduceRightOrNull", "reduceRightOrNull-ELGow60", "reduceRightOrNull-WyvcNBI", "reduceRightOrNull-s8dVfGU", "reduceRightOrNull-xzaTVY8", "reverse", "reverse-GBYM_sE", "reverse--ajY-9A", "reverse-QwZRm1k", "reverse-rL5Bavg", "reversed", "reversed-GBYM_sE", "([B)Ljava/util/List;", "reversed--ajY-9A", "([I)Ljava/util/List;", "reversed-QwZRm1k", "([J)Ljava/util/List;", "reversed-rL5Bavg", "([S)Ljava/util/List;", "reversedArray", "reversedArray-GBYM_sE", "reversedArray--ajY-9A", "reversedArray-QwZRm1k", "reversedArray-rL5Bavg", "scan", "scan-yXmHNn8", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scan-zi1B2BA", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scan-A8wKCXQ", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scan-zww5nb8", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "scanIndexed-3iWJZGE", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanIndexed-yVwIW0Q", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanIndexed-mwnnOCs", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanIndexed-bzxtMww", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduce-ELGow60", "scanReduce-WyvcNBI", "scanReduce-s8dVfGU", "scanReduce-xzaTVY8", "scanReduceIndexed", "scanReduceIndexed-EOyYB1Y", "([BLkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduceIndexed-D40WMg8", "([ILkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduceIndexed-z1zDJgo", "([JLkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduceIndexed-aLgx1Fo", "([SLkotlin/jvm/functions/Function3;)Ljava/util/List;", "single", "single-GBYM_sE", "single-JOV_ifY", "single--ajY-9A", "single-jgv0xPQ", "single-QwZRm1k", "single-MShoTSo", "single-rL5Bavg", "single-xTcfx_M", "singleOrNull", "singleOrNull-GBYM_sE", "singleOrNull-JOV_ifY", "singleOrNull--ajY-9A", "singleOrNull-jgv0xPQ", "singleOrNull-QwZRm1k", "singleOrNull-MShoTSo", "singleOrNull-rL5Bavg", "singleOrNull-xTcfx_M", "slice", "slice-JQknh5Q", "([BLjava/lang/Iterable;)Ljava/util/List;", "slice-c0bezYM", "([BLkotlin/ranges/IntRange;)Ljava/util/List;", "slice-HwE9HBo", "([ILjava/lang/Iterable;)Ljava/util/List;", "slice-tAntMlw", "([ILkotlin/ranges/IntRange;)Ljava/util/List;", "slice-F7u83W8", "([JLjava/lang/Iterable;)Ljava/util/List;", "slice-ZRhS8yI", "([JLkotlin/ranges/IntRange;)Ljava/util/List;", "slice-JGPC0-M", "([SLjava/lang/Iterable;)Ljava/util/List;", "slice-Q6IL4kU", "([SLkotlin/ranges/IntRange;)Ljava/util/List;", "sliceArray", "sliceArray-xo_DsdI", "sliceArray-c0bezYM", "([BLkotlin/ranges/IntRange;)[B", "sliceArray-CFIt9YE", "sliceArray-tAntMlw", "([ILkotlin/ranges/IntRange;)[I", "sliceArray-kzHmqpY", "sliceArray-ZRhS8yI", "([JLkotlin/ranges/IntRange;)[J", "sliceArray-ojwP5H8", "sliceArray-Q6IL4kU", "([SLkotlin/ranges/IntRange;)[S", "sort", "sort-GBYM_sE", "sort--ajY-9A", "sort-QwZRm1k", "sort-rL5Bavg", "sortDescending", "sortDescending-GBYM_sE", "sortDescending--ajY-9A", "sortDescending-QwZRm1k", "sortDescending-rL5Bavg", "sorted", "sorted-GBYM_sE", "sorted--ajY-9A", "sorted-QwZRm1k", "sorted-rL5Bavg", "sortedArray", "sortedArray-GBYM_sE", "sortedArray--ajY-9A", "sortedArray-QwZRm1k", "sortedArray-rL5Bavg", "sortedArrayDescending", "sortedArrayDescending-GBYM_sE", "sortedArrayDescending--ajY-9A", "sortedArrayDescending-QwZRm1k", "sortedArrayDescending-rL5Bavg", "sortedDescending", "sortedDescending-GBYM_sE", "sortedDescending--ajY-9A", "sortedDescending-QwZRm1k", "sortedDescending-rL5Bavg", "sum", "", "sumOfUByte", "([Lkotlin/UByte;)I", "sumOfUInt", "([Lkotlin/UInt;)I", "sumOfULong", "([Lkotlin/ULong;)J", "sumOfUShort", "([Lkotlin/UShort;)I", "sum-GBYM_sE", "sum--ajY-9A", "sum-QwZRm1k", "sum-rL5Bavg", "sumBy", "sumBy-JOV_ifY", "sumBy-jgv0xPQ", "sumBy-MShoTSo", "sumBy-xTcfx_M", "sumByDouble", "", "sumByDouble-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)D", "sumByDouble-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)D", "sumByDouble-MShoTSo", "([JLkotlin/jvm/functions/Function1;)D", "sumByDouble-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)D", "take", "take-PpDY95g", "take-qFRl0hI", "take-r7IrZao", "take-nggk6HY", "takeLast", "takeLast-PpDY95g", "takeLast-qFRl0hI", "takeLast-r7IrZao", "takeLast-nggk6HY", "takeLastWhile", "takeLastWhile-JOV_ifY", "takeLastWhile-jgv0xPQ", "takeLastWhile-MShoTSo", "takeLastWhile-xTcfx_M", "takeWhile", "takeWhile-JOV_ifY", "takeWhile-jgv0xPQ", "takeWhile-MShoTSo", "takeWhile-xTcfx_M", "toByteArray", "toByteArray-GBYM_sE", "toIntArray", "toIntArray--ajY-9A", "toLongArray", "toLongArray-QwZRm1k", "toShortArray", "toShortArray-rL5Bavg", "toTypedArray", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "toUByteArray", "([Lkotlin/UByte;)[B", "toUIntArray", "([Lkotlin/UInt;)[I", "toULongArray", "([Lkotlin/ULong;)[J", "toUShortArray", "([Lkotlin/UShort;)[S", "withIndex", "Lkotlin/collections/IndexedValue;", "withIndex-GBYM_sE", "([B)Ljava/lang/Iterable;", "withIndex--ajY-9A", "([I)Ljava/lang/Iterable;", "withIndex-QwZRm1k", "([J)Ljava/lang/Iterable;", "withIndex-rL5Bavg", "([S)Ljava/lang/Iterable;", "zip", "Lkotlin/Pair;", "zip-nl983wc", "([B[Ljava/lang/Object;)Ljava/util/List;", "a", "b", "zip-LuipOMY", "([B[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-kdPth3s", "([B[B)Ljava/util/List;", "zip-JAKpvQM", "([B[BLkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-JQknh5Q", "zip-UCnP4_w", "([BLjava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-C-E_24M", "([I[Ljava/lang/Object;)Ljava/util/List;", "zip-ZjwqOic", "([I[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-ctEhBpI", "([I[I)Ljava/util/List;", "zip-L83TJbI", "([I[ILkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-HwE9HBo", "zip-7znnbtw", "([ILjava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-f7H3mmw", "([J[Ljava/lang/Object;)Ljava/util/List;", "zip-8LME4QE", "([J[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-us8wMrg", "([J[J)Ljava/util/List;", "zip-PabeH-Q", "([J[JLkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-F7u83W8", "zip-TUPTUsU", "([JLjava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-uaTIQ5s", "([S[Ljava/lang/Object;)Ljava/util/List;", "zip-ePBmRWY", "([S[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-mazbYpA", "([S[S)Ljava/util/List;", "zip-gVVukQo", "([S[SLkotlin/jvm/functions/Function2;)Ljava/util/List;", "zip-JGPC0-M", "zip-kBb4a-s", "([SLjava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, pn="kotlin.collections", xi=1, xs="kotlin/collections/unsigned/UArraysKt")
public class UArraysKt___UArraysKt
  extends UArraysKt___UArraysJvmKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean all-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean all-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean all-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean all-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return ArraysKt.any(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return ArraysKt.any(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ArraysKt.any(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return ArraysKt.any(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean any-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]))).booleanValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] asByteArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] asIntArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return paramArrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] asLongArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return paramArrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] asShortArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return paramArrayOfShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] asUByteArray(@NotNull byte[] paramArrayOfByte)
  {
    return UByteArray.constructor-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] asUIntArray(@NotNull int[] paramArrayOfInt)
  {
    return UIntArray.constructor-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] asULongArray(@NotNull long[] paramArrayOfLong)
  {
    return ULongArray.constructor-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] asUShortArray(@NotNull short[] paramArrayOfShort)
  {
    return UShortArray.constructor-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int component1--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component1");
    return UIntArray.get-impl(paramArrayOfInt, 0);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte component1-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component1");
    return UByteArray.get-impl(paramArrayOfByte, 0);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long component1-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component1");
    return ULongArray.get-impl(paramArrayOfLong, 0);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short component1-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component1");
    return UShortArray.get-impl(paramArrayOfShort, 0);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int component2--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component2");
    return UIntArray.get-impl(paramArrayOfInt, 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte component2-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component2");
    return UByteArray.get-impl(paramArrayOfByte, 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long component2-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component2");
    return ULongArray.get-impl(paramArrayOfLong, 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short component2-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component2");
    return UShortArray.get-impl(paramArrayOfShort, 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int component3--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component3");
    return UIntArray.get-impl(paramArrayOfInt, 2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte component3-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component3");
    return UByteArray.get-impl(paramArrayOfByte, 2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long component3-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component3");
    return ULongArray.get-impl(paramArrayOfLong, 2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short component3-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component3");
    return UShortArray.get-impl(paramArrayOfShort, 2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int component4--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component4");
    return UIntArray.get-impl(paramArrayOfInt, 3);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte component4-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component4");
    return UByteArray.get-impl(paramArrayOfByte, 3);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long component4-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component4");
    return ULongArray.get-impl(paramArrayOfLong, 3);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short component4-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component4");
    return UShortArray.get-impl(paramArrayOfShort, 3);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int component5--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$component5");
    return UIntArray.get-impl(paramArrayOfInt, 4);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte component5-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$component5");
    return UByteArray.get-impl(paramArrayOfByte, 4);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long component5-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$component5");
    return ULongArray.get-impl(paramArrayOfLong, 4);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short component5-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$component5");
    return UShortArray.get-impl(paramArrayOfShort, 4);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contentEquals-ctEhBpI(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contentEquals-kdPth3s(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contentEquals-mazbYpA(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    return Arrays.equals(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contentEquals-us8wMrg(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int contentHashCode--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int contentHashCode-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int contentHashCode-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int contentHashCode-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String contentToString--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentToString");
    return CollectionsKt.joinToString$default(UIntArray.box-impl(paramArrayOfInt), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String contentToString-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentToString");
    return CollectionsKt.joinToString$default(UByteArray.box-impl(paramArrayOfByte), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String contentToString-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentToString");
    return CollectionsKt.joinToString$default(ULongArray.box-impl(paramArrayOfLong), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String contentToString-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentToString");
    return CollectionsKt.joinToString$default(UShortArray.box-impl(paramArrayOfShort), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] copyInto--B0-L2c(@NotNull long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    ArraysKt.copyInto(paramArrayOfLong1, paramArrayOfLong2, paramInt1, paramInt2, paramInt3);
    return paramArrayOfLong2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] copyInto-9-ak10g(@NotNull short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt1, int paramInt2, int paramInt3)
  {
    ArraysKt.copyInto(paramArrayOfShort1, paramArrayOfShort2, paramInt1, paramInt2, paramInt3);
    return paramArrayOfShort2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] copyInto-FUQE5sA(@NotNull byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    ArraysKt.copyInto(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
    return paramArrayOfByte2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] copyInto-sIZ3KeM(@NotNull int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    ArraysKt.copyInto(paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramInt3);
    return paramArrayOfInt2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] copyOf--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    return UIntArray.constructor-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] copyOf-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return UByteArray.constructor-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] copyOf-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
    return UByteArray.constructor-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] copyOf-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    return ULongArray.constructor-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] copyOf-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
    return UShortArray.constructor-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] copyOf-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
    return UIntArray.constructor-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] copyOf-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
    return ULongArray.constructor-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] copyOf-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    return UShortArray.constructor-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] copyOfRange--nroSd4(@NotNull long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      paramArrayOfLong = ArraysKt.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    }
    for (;;)
    {
      return ULongArray.constructor-impl(paramArrayOfLong);
      if (paramInt2 > paramArrayOfLong.length) {
        throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfLong.length));
      }
      paramArrayOfLong = Arrays.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] copyOfRange-4UcCI2c(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      paramArrayOfByte = ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return UByteArray.constructor-impl(paramArrayOfByte);
      if (paramInt2 > paramArrayOfByte.length) {
        throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfByte.length));
      }
      paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] copyOfRange-Aa5vz7o(@NotNull short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      paramArrayOfShort = ArraysKt.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    }
    for (;;)
    {
      return UShortArray.constructor-impl(paramArrayOfShort);
      if (paramInt2 > paramArrayOfShort.length) {
        throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfShort.length));
      }
      paramArrayOfShort = Arrays.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] copyOfRange-oBK06Vg(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      paramArrayOfInt = ArraysKt.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    }
    for (;;)
    {
      return UIntArray.constructor-impl(paramArrayOfInt);
      if (paramInt2 > paramArrayOfInt.length) {
        throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfInt.length));
      }
      paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int count-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[j]))).booleanValue()) {
        break label48;
      }
      i += 1;
    }
    label48:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int count-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int k = paramArrayOfLong.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[j]))).booleanValue()) {
        break label48;
      }
      i += 1;
    }
    label48:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int count-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[j]))).booleanValue()) {
        break label48;
      }
      i += 1;
    }
    label48:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int count-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int k = paramArrayOfShort.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[j]))).booleanValue()) {
        break label48;
      }
      i += 1;
    }
    label48:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> drop-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.takeLast-PpDY95g(paramArrayOfByte, RangesKt.coerceAtLeast(UByteArray.getSize-impl(paramArrayOfByte) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> drop-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.takeLast-nggk6HY(paramArrayOfShort, RangesKt.coerceAtLeast(UShortArray.getSize-impl(paramArrayOfShort) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> drop-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.takeLast-qFRl0hI(paramArrayOfInt, RangesKt.coerceAtLeast(UIntArray.getSize-impl(paramArrayOfInt) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> drop-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.takeLast-r7IrZao(paramArrayOfLong, RangesKt.coerceAtLeast(ULongArray.getSize-impl(paramArrayOfLong) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> dropLast-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.take-PpDY95g(paramArrayOfByte, RangesKt.coerceAtLeast(UByteArray.getSize-impl(paramArrayOfByte) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> dropLast-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.take-nggk6HY(paramArrayOfShort, RangesKt.coerceAtLeast(UShortArray.getSize-impl(paramArrayOfShort) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> dropLast-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.take-qFRl0hI(paramArrayOfInt, RangesKt.coerceAtLeast(UIntArray.getSize-impl(paramArrayOfInt) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> dropLast-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    return UArraysKt.take-r7IrZao(paramArrayOfLong, RangesKt.coerceAtLeast(ULongArray.getSize-impl(paramArrayOfLong) - paramInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> dropLastWhile-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).booleanValue()) {
        return UArraysKt.take-PpDY95g(paramArrayOfByte, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> dropLastWhile-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).booleanValue()) {
        return UArraysKt.take-r7IrZao(paramArrayOfLong, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> dropLastWhile-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).booleanValue()) {
        return UArraysKt.take-qFRl0hI(paramArrayOfInt, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> dropLastWhile-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).booleanValue()) {
        return UArraysKt.take-nggk6HY(paramArrayOfShort, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.emptyList();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> dropWhile-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    byte b;
    if (j < k)
    {
      b = paramArrayOfByte[j];
      if (i != 0) {
        localArrayList.add(UByte.box-impl(b));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue())
      {
        localArrayList.add(UByte.box-impl(b));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> dropWhile-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfLong.length;
    int j = 0;
    int i = 0;
    long l;
    if (j < k)
    {
      l = paramArrayOfLong[j];
      if (i != 0) {
        localArrayList.add(ULong.box-impl(l));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue())
      {
        localArrayList.add(ULong.box-impl(l));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> dropWhile-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    int m;
    if (j < k)
    {
      m = paramArrayOfInt[j];
      if (i != 0) {
        localArrayList.add(UInt.box-impl(m));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(m))).booleanValue())
      {
        localArrayList.add(UInt.box-impl(m));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> dropWhile-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfShort.length;
    int j = 0;
    int i = 0;
    short s;
    if (j < k)
    {
      s = paramArrayOfShort[j];
      if (i != 0) {
        localArrayList.add(UShort.box-impl(s));
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue())
      {
        localArrayList.add(UShort.box-impl(s));
        i = 1;
        continue;
        return (List)localArrayList;
      }
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short elementAtOrElse-CVVdw08(@NotNull short[] paramArrayOfShort, int paramInt, Function1<? super Integer, UShort> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return UShortArray.get-impl(paramArrayOfShort, paramInt);
    }
    return ((UShort)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int elementAtOrElse-QxvSvLU(@NotNull int[] paramArrayOfInt, int paramInt, Function1<? super Integer, UInt> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return UIntArray.get-impl(paramArrayOfInt, paramInt);
    }
    return ((UInt)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long elementAtOrElse-Xw8i6dc(@NotNull long[] paramArrayOfLong, int paramInt, Function1<? super Integer, ULong> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return ULongArray.get-impl(paramArrayOfLong, paramInt);
    }
    return ((ULong)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte elementAtOrElse-cO-VybQ(@NotNull byte[] paramArrayOfByte, int paramInt, Function1<? super Integer, UByte> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return UByteArray.get-impl(paramArrayOfByte, paramInt);
    }
    return ((UByte)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte elementAtOrNull-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    return UArraysKt.getOrNull-PpDY95g(paramArrayOfByte, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort elementAtOrNull-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    return UArraysKt.getOrNull-nggk6HY(paramArrayOfShort, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt elementAtOrNull-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return UArraysKt.getOrNull-qFRl0hI(paramArrayOfInt, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong elementAtOrNull-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    return UArraysKt.getOrNull-r7IrZao(paramArrayOfLong, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void fill-2fe2U9s(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$fill");
    ArraysKt.fill(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void fill-EtDCXyQ(@NotNull short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$fill");
    ArraysKt.fill(paramArrayOfShort, paramShort, paramInt1, paramInt2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void fill-K6DWlUc(@NotNull long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$fill");
    ArraysKt.fill(paramArrayOfLong, paramLong, paramInt1, paramInt2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void fill-WpHrYlw(@NotNull byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$fill");
    ArraysKt.fill(paramArrayOfByte, paramByte, paramInt1, paramInt2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> filter-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        localCollection.add(UByte.box-impl(b));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> filter-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        localCollection.add(ULong.box-impl(l));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> filter-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        localCollection.add(UInt.box-impl(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> filter-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        localCollection.add(UShort.box-impl(s));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> filterIndexed-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super Integer, ? super UByte, Boolean> paramFunction2)
  {
    int i = 0;
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UByte.box-impl(b))).booleanValue()) {
        localCollection.add(UByte.box-impl(b));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> filterIndexed-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super Integer, ? super UInt, Boolean> paramFunction2)
  {
    int i = 0;
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfInt[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UInt.box-impl(m))).booleanValue()) {
        localCollection.add(UInt.box-impl(m));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> filterIndexed-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super Integer, ? super ULong, Boolean> paramFunction2)
  {
    int i = 0;
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfLong.length;
    int j = 0;
    while (j < k)
    {
      long l = paramArrayOfLong[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), ULong.box-impl(l))).booleanValue()) {
        localCollection.add(ULong.box-impl(l));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> filterIndexed-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super Integer, ? super UShort, Boolean> paramFunction2)
  {
    int i = 0;
    Collection localCollection = (Collection)new ArrayList();
    int k = paramArrayOfShort.length;
    int j = 0;
    while (j < k)
    {
      short s = paramArrayOfShort[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UShort.box-impl(s))).booleanValue()) {
        localCollection.add(UShort.box-impl(s));
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UInt>> C filterIndexedTo--6EtJGI(@NotNull int[] paramArrayOfInt, C paramC, Function2<? super Integer, ? super UInt, Boolean> paramFunction2)
  {
    int i = 0;
    int k = paramArrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfInt[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UInt.box-impl(m))).booleanValue()) {
        paramC.add(UInt.box-impl(m));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UShort>> C filterIndexedTo-QqktQ3k(@NotNull short[] paramArrayOfShort, C paramC, Function2<? super Integer, ? super UShort, Boolean> paramFunction2)
  {
    int i = 0;
    int k = paramArrayOfShort.length;
    int j = 0;
    while (j < k)
    {
      short s = paramArrayOfShort[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UShort.box-impl(s))).booleanValue()) {
        paramC.add(UShort.box-impl(s));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UByte>> C filterIndexedTo-eNpIKz8(@NotNull byte[] paramArrayOfByte, C paramC, Function2<? super Integer, ? super UByte, Boolean> paramFunction2)
  {
    int i = 0;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), UByte.box-impl(b))).booleanValue()) {
        paramC.add(UByte.box-impl(b));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super ULong>> C filterIndexedTo-pe2Q0Dw(@NotNull long[] paramArrayOfLong, C paramC, Function2<? super Integer, ? super ULong, Boolean> paramFunction2)
  {
    int i = 0;
    int k = paramArrayOfLong.length;
    int j = 0;
    while (j < k)
    {
      long l = paramArrayOfLong[j];
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), ULong.box-impl(l))).booleanValue()) {
        paramC.add(ULong.box-impl(l));
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> filterNot-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        localCollection.add(UByte.box-impl(b));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> filterNot-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        localCollection.add(ULong.box-impl(l));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> filterNot-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        localCollection.add(UInt.box-impl(k));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> filterNot-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        localCollection.add(UShort.box-impl(s));
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super ULong>> C filterNotTo-HqK1JgA(@NotNull long[] paramArrayOfLong, C paramC, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        paramC.add(ULong.box-impl(l));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UShort>> C filterNotTo-oEOeDjA(@NotNull short[] paramArrayOfShort, C paramC, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        paramC.add(UShort.box-impl(s));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UInt>> C filterNotTo-wU5IKMo(@NotNull int[] paramArrayOfInt, C paramC, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        paramC.add(UInt.box-impl(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UByte>> C filterNotTo-wzUQCXU(@NotNull byte[] paramArrayOfByte, C paramC, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        paramC.add(UByte.box-impl(b));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super ULong>> C filterTo-HqK1JgA(@NotNull long[] paramArrayOfLong, C paramC, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        paramC.add(ULong.box-impl(l));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UShort>> C filterTo-oEOeDjA(@NotNull short[] paramArrayOfShort, C paramC, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        paramC.add(UShort.box-impl(s));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UInt>> C filterTo-wU5IKMo(@NotNull int[] paramArrayOfInt, C paramC, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        paramC.add(UInt.box-impl(k));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<? super UByte>> C filterTo-wzUQCXU(@NotNull byte[] paramArrayOfByte, C paramC, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        paramC.add(UByte.box-impl(b));
      }
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte find-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        return UByte.box-impl(b);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong find-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        return ULong.box-impl(l);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt find-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        return UInt.box-impl(k);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort find-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        return UShort.box-impl(s);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte findLast-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfByte);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        byte b = UByteArray.get-impl(paramArrayOfByte, i);
        if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
          return UByte.box-impl(b);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong findLast-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfLong);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        long l = ULongArray.get-impl(paramArrayOfLong, i);
        if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
          return ULong.box-impl(l);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt findLast-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfInt);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        int k = UIntArray.get-impl(paramArrayOfInt, i);
        if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
          return UInt.box-impl(k);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort findLast-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfShort);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        short s = UShortArray.get-impl(paramArrayOfShort, i);
        if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
          return UShort.box-impl(s);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int first--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UInt.constructor-impl(ArraysKt.first(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte first-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UByte.constructor-impl(ArraysKt.first(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte first-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        return b;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long first-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        return l;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long first-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULong.constructor-impl(ArraysKt.first(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int first-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        return k;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short first-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UShort.constructor-impl(ArraysKt.first(paramArrayOfShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short first-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        return s;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt firstOrNull--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$firstOrNull");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    return UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte firstOrNull-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$firstOrNull");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    return UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte firstOrNull-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        return UByte.box-impl(b);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong firstOrNull-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        return ULong.box-impl(l);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong firstOrNull-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$firstOrNull");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    return ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt firstOrNull-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
        return UInt.box-impl(k);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort firstOrNull-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$firstOrNull");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    return UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, 0));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort firstOrNull-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        return UShort.box-impl(s);
      }
      i += 1;
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> flatMap-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends Iterable<? extends R>> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> flatMap-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends Iterable<? extends R>> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> flatMap-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends Iterable<? extends R>> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> flatMap-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends Iterable<? extends R>> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C flatMapTo-HqK1JgA(@NotNull long[] paramArrayOfLong, C paramC, Function1<? super ULong, ? extends Iterable<? extends R>> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C flatMapTo-oEOeDjA(@NotNull short[] paramArrayOfShort, C paramC, Function1<? super UShort, ? extends Iterable<? extends R>> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C flatMapTo-wU5IKMo(@NotNull int[] paramArrayOfInt, C paramC, Function1<? super UInt, ? extends Iterable<? extends R>> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C flatMapTo-wzUQCXU(@NotNull byte[] paramArrayOfByte, C paramC, Function1<? super UByte, ? extends Iterable<? extends R>> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R fold-A8wKCXQ(@NotNull long[] paramArrayOfLong, R paramR, Function2<? super R, ? super ULong, ? extends R> paramFunction2)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, ULong.box-impl(paramArrayOfLong[i]));
      i += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R fold-yXmHNn8(@NotNull byte[] paramArrayOfByte, R paramR, Function2<? super R, ? super UByte, ? extends R> paramFunction2)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UByte.box-impl(paramArrayOfByte[i]));
      i += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R fold-zi1B2BA(@NotNull int[] paramArrayOfInt, R paramR, Function2<? super R, ? super UInt, ? extends R> paramFunction2)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UInt.box-impl(paramArrayOfInt[i]));
      i += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R fold-zww5nb8(@NotNull short[] paramArrayOfShort, R paramR, Function2<? super R, ? super UShort, ? extends R> paramFunction2)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UShort.box-impl(paramArrayOfShort[i]));
      i += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldIndexed-3iWJZGE(@NotNull byte[] paramArrayOfByte, R paramR, Function3<? super Integer, ? super R, ? super UByte, ? extends R> paramFunction3)
  {
    int j = 0;
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
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, UByte.box-impl(b));
      j += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldIndexed-bzxtMww(@NotNull short[] paramArrayOfShort, R paramR, Function3<? super Integer, ? super R, ? super UShort, ? extends R> paramFunction3)
  {
    int j = 0;
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
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, UShort.box-impl(s));
      j += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldIndexed-mwnnOCs(@NotNull long[] paramArrayOfLong, R paramR, Function3<? super Integer, ? super R, ? super ULong, ? extends R> paramFunction3)
  {
    int j = 0;
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
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, ULong.box-impl(l));
      j += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldIndexed-yVwIW0Q(@NotNull int[] paramArrayOfInt, R paramR, Function3<? super Integer, ? super R, ? super UInt, ? extends R> paramFunction3)
  {
    int j = 0;
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
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, UInt.box-impl(n));
      j += 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRight-A8wKCXQ(@NotNull long[] paramArrayOfLong, R paramR, Function2<? super ULong, ? super R, ? extends R> paramFunction2)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRight-yXmHNn8(@NotNull byte[] paramArrayOfByte, R paramR, Function2<? super UByte, ? super R, ? extends R> paramFunction2)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRight-zi1B2BA(@NotNull int[] paramArrayOfInt, R paramR, Function2<? super UInt, ? super R, ? extends R> paramFunction2)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRight-zww5nb8(@NotNull short[] paramArrayOfShort, R paramR, Function2<? super UShort, ? super R, ? extends R> paramFunction2)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRightIndexed-3iWJZGE(@NotNull byte[] paramArrayOfByte, R paramR, Function3<? super Integer, ? super UByte, ? super R, ? extends R> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRightIndexed-bzxtMww(@NotNull short[] paramArrayOfShort, R paramR, Function3<? super Integer, ? super UShort, ? super R, ? extends R> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRightIndexed-mwnnOCs(@NotNull long[] paramArrayOfLong, R paramR, Function3<? super Integer, ? super ULong, ? super R, ? extends R> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> R foldRightIndexed-yVwIW0Q(@NotNull int[] paramArrayOfInt, R paramR, Function3<? super Integer, ? super UInt, ? super R, ? extends R> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEach-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Unit> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEach-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Unit> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEach-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Unit> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEach-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Unit> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEachIndexed-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super Integer, ? super UByte, Unit> paramFunction2)
  {
    int j = 0;
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
      paramFunction2.invoke(Integer.valueOf(k), UByte.box-impl(b));
      j += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEachIndexed-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super Integer, ? super UInt, Unit> paramFunction2)
  {
    int j = 0;
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
      paramFunction2.invoke(Integer.valueOf(k), UInt.box-impl(n));
      j += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEachIndexed-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super Integer, ? super ULong, Unit> paramFunction2)
  {
    int j = 0;
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
      paramFunction2.invoke(Integer.valueOf(k), ULong.box-impl(l));
      j += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void forEachIndexed-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super Integer, ? super UShort, Unit> paramFunction2)
  {
    int j = 0;
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
      paramFunction2.invoke(Integer.valueOf(k), UShort.box-impl(s));
      j += 1;
    }
  }
  
  @NotNull
  public static final IntRange getIndices--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$indices");
    return ArraysKt.getIndices(paramArrayOfInt);
  }
  
  @NotNull
  public static final IntRange getIndices-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$indices");
    return ArraysKt.getIndices(paramArrayOfByte);
  }
  
  @NotNull
  public static final IntRange getIndices-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$indices");
    return ArraysKt.getIndices(paramArrayOfLong);
  }
  
  @NotNull
  public static final IntRange getIndices-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$indices");
    return ArraysKt.getIndices(paramArrayOfShort);
  }
  
  public static final int getLastIndex--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastIndex");
    return ArraysKt.getLastIndex(paramArrayOfInt);
  }
  
  public static final int getLastIndex-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastIndex");
    return ArraysKt.getLastIndex(paramArrayOfByte);
  }
  
  public static final int getLastIndex-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastIndex");
    return ArraysKt.getLastIndex(paramArrayOfLong);
  }
  
  public static final int getLastIndex-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastIndex");
    return ArraysKt.getLastIndex(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short getOrElse-CVVdw08(@NotNull short[] paramArrayOfShort, int paramInt, Function1<? super Integer, UShort> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return UShortArray.get-impl(paramArrayOfShort, paramInt);
    }
    return ((UShort)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int getOrElse-QxvSvLU(@NotNull int[] paramArrayOfInt, int paramInt, Function1<? super Integer, UInt> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return UIntArray.get-impl(paramArrayOfInt, paramInt);
    }
    return ((UInt)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long getOrElse-Xw8i6dc(@NotNull long[] paramArrayOfLong, int paramInt, Function1<? super Integer, ULong> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return ULongArray.get-impl(paramArrayOfLong, paramInt);
    }
    return ((ULong)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte getOrElse-cO-VybQ(@NotNull byte[] paramArrayOfByte, int paramInt, Function1<? super Integer, UByte> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return UByteArray.get-impl(paramArrayOfByte, paramInt);
    }
    return ((UByte)paramFunction1.invoke(Integer.valueOf(paramInt))).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte getOrNull-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfByte))) {
      return UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, paramInt));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort getOrNull-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfShort))) {
      return UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, paramInt));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt getOrNull-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfInt))) {
      return UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, paramInt));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong getOrNull-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(paramArrayOfLong))) {
      return ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, paramInt));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, List<V>> groupBy--_j2Y-Q(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends K> paramFunction1, Function1<? super ULong, ? extends V> paramFunction11)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject3 = paramFunction1.invoke(ULong.box-impl(l));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(ULong.box-impl(l)));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, List<V>> groupBy-3bBvP4M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends K> paramFunction1, Function1<? super UShort, ? extends V> paramFunction11)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject3 = paramFunction1.invoke(UShort.box-impl(s));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(UShort.box-impl(s)));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K> Map<K, List<UByte>> groupBy-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends K> paramFunction1)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject3 = paramFunction1.invoke(UByte.box-impl(b));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(UByte.box-impl(b));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, List<V>> groupBy-L4rlFek(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends K> paramFunction1, Function1<? super UInt, ? extends V> paramFunction11)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject3 = paramFunction1.invoke(UInt.box-impl(k));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(UInt.box-impl(k)));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K> Map<K, List<ULong>> groupBy-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends K> paramFunction1)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject3 = paramFunction1.invoke(ULong.box-impl(l));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(ULong.box-impl(l));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V> Map<K, List<V>> groupBy-bBsjw1Y(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends K> paramFunction1, Function1<? super UByte, ? extends V> paramFunction11)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject3 = paramFunction1.invoke(UByte.box-impl(b));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(paramFunction11.invoke(UByte.box-impl(b)));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K> Map<K, List<UInt>> groupBy-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends K> paramFunction1)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject3 = paramFunction1.invoke(UInt.box-impl(k));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(UInt.box-impl(k));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K> Map<K, List<UShort>> groupBy-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends K> paramFunction1)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject3 = paramFunction1.invoke(UShort.box-impl(s));
      Object localObject2 = localMap.get(localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject3, localObject1);
      }
      ((List)localObject1).add(UShort.box-impl(s));
      i += 1;
    }
    return localMap;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, M extends Map<? super K, List<UInt>>> M groupByTo-4D70W2E(@NotNull int[] paramArrayOfInt, M paramM, Function1<? super UInt, ? extends K> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(UInt.box-impl(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(UInt.box-impl(k));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, M extends Map<? super K, List<UByte>>> M groupByTo-H21X9dk(@NotNull byte[] paramArrayOfByte, M paramM, Function1<? super UByte, ? extends K> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(UByte.box-impl(b));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(UByte.box-impl(b));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V, M extends Map<? super K, List<V>>> M groupByTo-JM6gNCM(@NotNull int[] paramArrayOfInt, M paramM, Function1<? super UInt, ? extends K> paramFunction1, Function1<? super UInt, ? extends V> paramFunction11)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject2 = paramFunction1.invoke(UInt.box-impl(k));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(UInt.box-impl(k)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V, M extends Map<? super K, List<V>>> M groupByTo-QxgOkWg(@NotNull long[] paramArrayOfLong, M paramM, Function1<? super ULong, ? extends K> paramFunction1, Function1<? super ULong, ? extends V> paramFunction11)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(ULong.box-impl(l));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(ULong.box-impl(l)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, M extends Map<? super K, List<ULong>>> M groupByTo-X6OPwNk(@NotNull long[] paramArrayOfLong, M paramM, Function1<? super ULong, ? extends K> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject2 = paramFunction1.invoke(ULong.box-impl(l));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(ULong.box-impl(l));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, M extends Map<? super K, List<UShort>>> M groupByTo-ciTST-8(@NotNull short[] paramArrayOfShort, M paramM, Function1<? super UShort, ? extends K> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(UShort.box-impl(s));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(UShort.box-impl(s));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V, M extends Map<? super K, List<V>>> M groupByTo-q8RuPII(@NotNull short[] paramArrayOfShort, M paramM, Function1<? super UShort, ? extends K> paramFunction1, Function1<? super UShort, ? extends V> paramFunction11)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < j)
    {
      short s = paramArrayOfShort[i];
      Object localObject2 = paramFunction1.invoke(UShort.box-impl(s));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(UShort.box-impl(s)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <K, V, M extends Map<? super K, List<V>>> M groupByTo-qOZmbk8(@NotNull byte[] paramArrayOfByte, M paramM, Function1<? super UByte, ? extends K> paramFunction1, Function1<? super UByte, ? extends V> paramFunction11)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      byte b = paramArrayOfByte[i];
      Object localObject2 = paramFunction1.invoke(UByte.box-impl(b));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(UByte.box-impl(b)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOf-3uqUaXg(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    return ArraysKt.indexOf(paramArrayOfLong, paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOf-XzdR7RA(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    return ArraysKt.indexOf(paramArrayOfShort, paramShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOf-gMuBH34(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    return ArraysKt.indexOf(paramArrayOfByte, paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOf-uWY9BYg(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return ArraysKt.indexOf(paramArrayOfInt, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfFirst-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(UByte.constructor-impl(paramArrayOfByte[i])))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfFirst-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(ULong.constructor-impl(paramArrayOfLong[i])))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfFirst-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(UInt.constructor-impl(paramArrayOfInt[i])))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfFirst-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(UShort.constructor-impl(paramArrayOfShort[i])))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfLast-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = paramArrayOfByte.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(UByte.constructor-impl(paramArrayOfByte[i])))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfLast-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = paramArrayOfLong.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(ULong.constructor-impl(paramArrayOfLong[i])))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfLast-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(UInt.constructor-impl(paramArrayOfInt[i])))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int indexOfLast-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = paramArrayOfShort.length - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(UShort.constructor-impl(paramArrayOfShort[i])))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int last--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UInt.constructor-impl(ArraysKt.last(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte last-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UByte.constructor-impl(ArraysKt.last(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte last-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfByte);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        byte b = UByteArray.get-impl(paramArrayOfByte, i);
        if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
          return b;
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long last-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfLong);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        long l = ULongArray.get-impl(paramArrayOfLong, i);
        if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
          return l;
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long last-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULong.constructor-impl(ArraysKt.last(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int last-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfInt);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        int k = UIntArray.get-impl(paramArrayOfInt, i);
        if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
          return k;
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short last-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UShort.constructor-impl(ArraysKt.last(paramArrayOfShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short last-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfShort);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        short s = UShortArray.get-impl(paramArrayOfShort, i);
        if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
          return s;
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int lastIndexOf-3uqUaXg(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    return ArraysKt.lastIndexOf(paramArrayOfLong, paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int lastIndexOf-XzdR7RA(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    return ArraysKt.lastIndexOf(paramArrayOfShort, paramShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int lastIndexOf-gMuBH34(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    return ArraysKt.lastIndexOf(paramArrayOfByte, paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int lastIndexOf-uWY9BYg(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return ArraysKt.lastIndexOf(paramArrayOfInt, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt lastOrNull--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$lastOrNull");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    return UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, UIntArray.getSize-impl(paramArrayOfInt) - 1));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte lastOrNull-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$lastOrNull");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    return UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, UByteArray.getSize-impl(paramArrayOfByte) - 1));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte lastOrNull-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfByte);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        byte b = UByteArray.get-impl(paramArrayOfByte, i);
        if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
          return UByte.box-impl(b);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong lastOrNull-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfLong);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        long l = ULongArray.get-impl(paramArrayOfLong, i);
        if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
          return ULong.box-impl(l);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong lastOrNull-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$lastOrNull");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    return ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, ULongArray.getSize-impl(paramArrayOfLong) - 1));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt lastOrNull-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfInt);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        int k = UIntArray.get-impl(paramArrayOfInt, i);
        if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {
          return UInt.box-impl(k);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort lastOrNull-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$lastOrNull");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    return UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, UShortArray.getSize-impl(paramArrayOfShort) - 1));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort lastOrNull-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfShort);
    int i = localIntRange.getLast();
    int j = localIntRange.getFirst();
    if (i >= j) {
      for (;;)
      {
        short s = UShortArray.get-impl(paramArrayOfShort, i);
        if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
          return UShort.box-impl(s);
        }
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> map-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends R> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList(UByteArray.getSize-impl(paramArrayOfByte));
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> map-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends R> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList(ULongArray.getSize-impl(paramArrayOfLong));
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> map-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends R> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList(UIntArray.getSize-impl(paramArrayOfInt));
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> map-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends R> paramFunction1)
  {
    Collection localCollection = (Collection)new ArrayList(UShortArray.getSize-impl(paramArrayOfShort));
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i])));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> mapIndexed-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super Integer, ? super UByte, ? extends R> paramFunction2)
  {
    int j = 0;
    Collection localCollection = (Collection)new ArrayList(UByteArray.getSize-impl(paramArrayOfByte));
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
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), UByte.box-impl(b)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> mapIndexed-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super Integer, ? super UInt, ? extends R> paramFunction2)
  {
    int j = 0;
    Collection localCollection = (Collection)new ArrayList(UIntArray.getSize-impl(paramArrayOfInt));
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
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), UInt.box-impl(n)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> mapIndexed-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super Integer, ? super ULong, ? extends R> paramFunction2)
  {
    int j = 0;
    Collection localCollection = (Collection)new ArrayList(ULongArray.getSize-impl(paramArrayOfLong));
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
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), ULong.box-impl(l)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> mapIndexed-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super Integer, ? super UShort, ? extends R> paramFunction2)
  {
    int j = 0;
    Collection localCollection = (Collection)new ArrayList(UShortArray.getSize-impl(paramArrayOfShort));
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
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), UShort.box-impl(s)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapIndexedTo--6EtJGI(@NotNull int[] paramArrayOfInt, C paramC, Function2<? super Integer, ? super UInt, ? extends R> paramFunction2)
  {
    int j = 0;
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
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), UInt.box-impl(n)));
      j += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapIndexedTo-QqktQ3k(@NotNull short[] paramArrayOfShort, C paramC, Function2<? super Integer, ? super UShort, ? extends R> paramFunction2)
  {
    int j = 0;
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
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), UShort.box-impl(s)));
      j += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapIndexedTo-eNpIKz8(@NotNull byte[] paramArrayOfByte, C paramC, Function2<? super Integer, ? super UByte, ? extends R> paramFunction2)
  {
    int j = 0;
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
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), UByte.box-impl(b)));
      j += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapIndexedTo-pe2Q0Dw(@NotNull long[] paramArrayOfLong, C paramC, Function2<? super Integer, ? super ULong, ? extends R> paramFunction2)
  {
    int j = 0;
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
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), ULong.box-impl(l)));
      j += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapTo-HqK1JgA(@NotNull long[] paramArrayOfLong, C paramC, Function1<? super ULong, ? extends R> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapTo-oEOeDjA(@NotNull short[] paramArrayOfShort, C paramC, Function1<? super UShort, ? extends R> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapTo-wU5IKMo(@NotNull int[] paramArrayOfInt, C paramC, Function1<? super UInt, ? extends R> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, C extends Collection<? super R>> C mapTo-wzUQCXU(@NotNull byte[] paramArrayOfByte, C paramC, Function1<? super UByte, ? extends R> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i])));
      i += 1;
    }
    return paramC;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt max--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$max");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int j = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = UIntArray.get-impl(paramArrayOfInt, j);
        i = k;
        if (UnsignedKt.uintCompare(k, m) < 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte max-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$max");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    int i = UByteArray.get-impl(paramArrayOfByte, 0);
    int m = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfByte);
    int j = i;
    if (1 <= n) {
      for (j = i;; j = i)
      {
        int k = UByteArray.get-impl(paramArrayOfByte, m);
        i = j;
        if (Intrinsics.compare(j & 0xFF, k & 0xFF) < 0) {
          i = k;
        }
        j = i;
        if (m == n) {
          break;
        }
        m += 1;
      }
    }
    return UByte.box-impl(j);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong max-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$max");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= j) {
      for (l2 = l1;; l2 = l1)
      {
        long l3 = ULongArray.get-impl(paramArrayOfLong, i);
        l1 = l2;
        if (UnsignedKt.ulongCompare(l2, l3) < 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort max-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$max");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    int i = UShortArray.get-impl(paramArrayOfShort, 0);
    int m = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfShort);
    int j = i;
    if (1 <= n) {
      for (j = i;; j = i)
      {
        int k = UShortArray.get-impl(paramArrayOfShort, m);
        i = j;
        if (Intrinsics.compare(j & 0xFFFF, k & 0xFFFF) < 0) {
          i = k;
        }
        j = i;
        if (m == n) {
          break;
        }
        m += 1;
      }
    }
    return UShort.box-impl(j);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UByte maxBy-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends R> paramFunction1)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j == 0) {
      return UByte.box-impl(b1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UByte.box-impl(b1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        b2 = UByteArray.get-impl(paramArrayOfByte, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UByte.box-impl(b2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          b1 = b2;
        }
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    byte b2 = b1;
    return UByte.box-impl(b2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> ULong maxBy-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends R> paramFunction1)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j == 0) {
      return ULong.box-impl(l1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(ULong.box-impl(l1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        l2 = ULongArray.get-impl(paramArrayOfLong, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(ULong.box-impl(l2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          l1 = l2;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    long l2 = l1;
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UInt maxBy-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends R> paramFunction1)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (m == 0) {
      return UInt.box-impl(i);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UInt.box-impl(i));
    int j = 1;
    if (1 <= m) {
      for (;;)
      {
        k = UIntArray.get-impl(paramArrayOfInt, j);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UInt.box-impl(k));
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
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UShort maxBy-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends R> paramFunction1)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j == 0) {
      return UShort.box-impl(s1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UShort.box-impl(s1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        s2 = UShortArray.get-impl(paramArrayOfShort, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UShort.box-impl(s2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          s1 = s2;
        }
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    short s2 = s1;
    return UShort.box-impl(s2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte maxWith-XMRcp5o(@NotNull byte[] paramArrayOfByte, @NotNull Comparator<? super UByte> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= j) {
      for (b2 = b1;; b2 = b1)
      {
        byte b3 = UByteArray.get-impl(paramArrayOfByte, i);
        b1 = b2;
        if (paramComparator.compare(UByte.box-impl(b2), UByte.box-impl(b3)) < 0) {
          b1 = b3;
        }
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return UByte.box-impl(b2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt maxWith-YmdZ_VM(@NotNull int[] paramArrayOfInt, @NotNull Comparator<? super UInt> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int j = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = UIntArray.get-impl(paramArrayOfInt, j);
        i = k;
        if (paramComparator.compare(UInt.box-impl(k), UInt.box-impl(m)) < 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort maxWith-eOHTfZs(@NotNull short[] paramArrayOfShort, @NotNull Comparator<? super UShort> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= j) {
      for (s2 = s1;; s2 = s1)
      {
        short s3 = UShortArray.get-impl(paramArrayOfShort, i);
        s1 = s2;
        if (paramComparator.compare(UShort.box-impl(s2), UShort.box-impl(s3)) < 0) {
          s1 = s3;
        }
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return UShort.box-impl(s2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong maxWith-zrEWJaI(@NotNull long[] paramArrayOfLong, @NotNull Comparator<? super ULong> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= j) {
      for (l2 = l1;; l2 = l1)
      {
        long l3 = ULongArray.get-impl(paramArrayOfLong, i);
        l1 = l2;
        if (paramComparator.compare(ULong.box-impl(l2), ULong.box-impl(l3)) < 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt min--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$min");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int j = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = UIntArray.get-impl(paramArrayOfInt, j);
        i = k;
        if (UnsignedKt.uintCompare(k, m) > 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte min-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$min");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    int i = UByteArray.get-impl(paramArrayOfByte, 0);
    int m = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfByte);
    int j = i;
    if (1 <= n) {
      for (j = i;; j = i)
      {
        int k = UByteArray.get-impl(paramArrayOfByte, m);
        i = j;
        if (Intrinsics.compare(j & 0xFF, k & 0xFF) > 0) {
          i = k;
        }
        j = i;
        if (m == n) {
          break;
        }
        m += 1;
      }
    }
    return UByte.box-impl(j);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong min-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$min");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= j) {
      for (l2 = l1;; l2 = l1)
      {
        long l3 = ULongArray.get-impl(paramArrayOfLong, i);
        l1 = l2;
        if (UnsignedKt.ulongCompare(l2, l3) > 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort min-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$min");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    int i = UShortArray.get-impl(paramArrayOfShort, 0);
    int m = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfShort);
    int j = i;
    if (1 <= n) {
      for (j = i;; j = i)
      {
        int k = UShortArray.get-impl(paramArrayOfShort, m);
        i = j;
        if (Intrinsics.compare(j & 0xFFFF, k & 0xFFFF) > 0) {
          i = k;
        }
        j = i;
        if (m == n) {
          break;
        }
        m += 1;
      }
    }
    return UShort.box-impl(j);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UByte minBy-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, ? extends R> paramFunction1)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j == 0) {
      return UByte.box-impl(b1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UByte.box-impl(b1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        b2 = UByteArray.get-impl(paramArrayOfByte, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UByte.box-impl(b2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          b1 = b2;
        }
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    byte b2 = b1;
    return UByte.box-impl(b2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> ULong minBy-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, ? extends R> paramFunction1)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j == 0) {
      return ULong.box-impl(l1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(ULong.box-impl(l1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        l2 = ULongArray.get-impl(paramArrayOfLong, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(ULong.box-impl(l2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          l1 = l2;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    long l2 = l1;
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UInt minBy-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, ? extends R> paramFunction1)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (m == 0) {
      return UInt.box-impl(i);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UInt.box-impl(i));
    int j = 1;
    if (1 <= m) {
      for (;;)
      {
        k = UIntArray.get-impl(paramArrayOfInt, j);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UInt.box-impl(k));
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
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R extends Comparable<? super R>> UShort minBy-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, ? extends R> paramFunction1)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j == 0) {
      return UShort.box-impl(s1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(UShort.box-impl(s1));
    int i = 1;
    if (1 <= j) {
      for (;;)
      {
        s2 = UShortArray.get-impl(paramArrayOfShort, i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(UShort.box-impl(s2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          s1 = s2;
        }
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    short s2 = s1;
    return UShort.box-impl(s2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte minWith-XMRcp5o(@NotNull byte[] paramArrayOfByte, @NotNull Comparator<? super UByte> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    byte b2 = b1;
    if (1 <= j) {
      for (b2 = b1;; b2 = b1)
      {
        byte b3 = UByteArray.get-impl(paramArrayOfByte, i);
        b1 = b2;
        if (paramComparator.compare(UByte.box-impl(b2), UByte.box-impl(b3)) > 0) {
          b1 = b3;
        }
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return UByte.box-impl(b2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt minWith-YmdZ_VM(@NotNull int[] paramArrayOfInt, @NotNull Comparator<? super UInt> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int i = UIntArray.get-impl(paramArrayOfInt, 0);
    int j = 1;
    int n = ArraysKt.getLastIndex(paramArrayOfInt);
    int k = i;
    if (1 <= n) {
      for (k = i;; k = i)
      {
        int m = UIntArray.get-impl(paramArrayOfInt, j);
        i = k;
        if (paramComparator.compare(UInt.box-impl(k), UInt.box-impl(m)) > 0) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort minWith-eOHTfZs(@NotNull short[] paramArrayOfShort, @NotNull Comparator<? super UShort> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    short s2 = s1;
    if (1 <= j) {
      for (s2 = s1;; s2 = s1)
      {
        short s3 = UShortArray.get-impl(paramArrayOfShort, i);
        s1 = s2;
        if (paramComparator.compare(UShort.box-impl(s2), UShort.box-impl(s3)) > 0) {
          s1 = s3;
        }
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return UShort.box-impl(s2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong minWith-zrEWJaI(@NotNull long[] paramArrayOfLong, @NotNull Comparator<? super ULong> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l1 = ULongArray.get-impl(paramArrayOfLong, 0);
    int i = 1;
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l2 = l1;
    if (1 <= j) {
      for (l2 = l1;; l2 = l1)
      {
        long l3 = ULongArray.get-impl(paramArrayOfLong, i);
        l1 = l2;
        if (paramComparator.compare(ULong.box-impl(l2), ULong.box-impl(l3)) > 0) {
          l1 = l3;
        }
        l2 = l1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UIntArray.isEmpty-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UByteArray.isEmpty-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULongArray.isEmpty-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UShortArray.isEmpty-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean none-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] plus-3uqUaXg(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    return ULongArray.constructor-impl(ArraysKt.plus(paramArrayOfLong, paramLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] plus-CFIt9YE(@NotNull int[] paramArrayOfInt, @NotNull Collection<UInt> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = UIntArray.getSize-impl(paramArrayOfInt);
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, UIntArray.getSize-impl(paramArrayOfInt) + paramCollection.size());
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfInt[i] = ((UInt)paramCollection.next()).unbox-impl();
      i += 1;
    }
    return UIntArray.constructor-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] plus-XzdR7RA(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    return UShortArray.constructor-impl(ArraysKt.plus(paramArrayOfShort, paramShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] plus-ctEhBpI(@NotNull int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$plus");
    return UIntArray.constructor-impl(ArraysKt.plus(paramArrayOfInt1, paramArrayOfInt2));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] plus-gMuBH34(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    return UByteArray.constructor-impl(ArraysKt.plus(paramArrayOfByte, paramByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] plus-kdPth3s(@NotNull byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$plus");
    return UByteArray.constructor-impl(ArraysKt.plus(paramArrayOfByte1, paramArrayOfByte2));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] plus-kzHmqpY(@NotNull long[] paramArrayOfLong, @NotNull Collection<ULong> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = ULongArray.getSize-impl(paramArrayOfLong);
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, ULongArray.getSize-impl(paramArrayOfLong) + paramCollection.size());
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfLong[i] = ((ULong)paramCollection.next()).unbox-impl();
      i += 1;
    }
    return ULongArray.constructor-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] plus-mazbYpA(@NotNull short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$plus");
    return UShortArray.constructor-impl(ArraysKt.plus(paramArrayOfShort1, paramArrayOfShort2));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] plus-ojwP5H8(@NotNull short[] paramArrayOfShort, @NotNull Collection<UShort> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = UShortArray.getSize-impl(paramArrayOfShort);
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, UShortArray.getSize-impl(paramArrayOfShort) + paramCollection.size());
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfShort[i] = ((UShort)paramCollection.next()).unbox-impl();
      i += 1;
    }
    return UShortArray.constructor-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] plus-uWY9BYg(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    return UIntArray.constructor-impl(ArraysKt.plus(paramArrayOfInt, paramInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] plus-us8wMrg(@NotNull long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$plus");
    return ULongArray.constructor-impl(ArraysKt.plus(paramArrayOfLong1, paramArrayOfLong2));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] plus-xo_DsdI(@NotNull byte[] paramArrayOfByte, @NotNull Collection<UByte> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = UByteArray.getSize-impl(paramArrayOfByte);
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, UByteArray.getSize-impl(paramArrayOfByte) + paramCollection.size());
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfByte[i] = ((UByte)paramCollection.next()).unbox-impl();
      i += 1;
    }
    return UByteArray.constructor-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int random--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UArraysKt.random-2D5oskM(paramArrayOfInt, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int random-2D5oskM(@NotNull int[] paramArrayOfInt, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return UIntArray.get-impl(paramArrayOfInt, paramRandom.nextInt(UIntArray.getSize-impl(paramArrayOfInt)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte random-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UArraysKt.random-oSF2wD8(paramArrayOfByte, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long random-JzugnMA(@NotNull long[] paramArrayOfLong, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return ULongArray.get-impl(paramArrayOfLong, paramRandom.nextInt(ULongArray.getSize-impl(paramArrayOfLong)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long random-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return UArraysKt.random-JzugnMA(paramArrayOfLong, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte random-oSF2wD8(@NotNull byte[] paramArrayOfByte, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return UByteArray.get-impl(paramArrayOfByte, paramRandom.nextInt(UByteArray.getSize-impl(paramArrayOfByte)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short random-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UArraysKt.random-s5X_as8(paramArrayOfShort, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short random-s5X_as8(@NotNull short[] paramArrayOfShort, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    }
    return UShortArray.get-impl(paramArrayOfShort, paramRandom.nextInt(UShortArray.getSize-impl(paramArrayOfShort)));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt randomOrNull--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UArraysKt.randomOrNull-2D5oskM(paramArrayOfInt, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt randomOrNull-2D5oskM(@NotNull int[] paramArrayOfInt, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    return UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, paramRandom.nextInt(UIntArray.getSize-impl(paramArrayOfInt))));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte randomOrNull-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UArraysKt.randomOrNull-oSF2wD8(paramArrayOfByte, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong randomOrNull-JzugnMA(@NotNull long[] paramArrayOfLong, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    return ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, paramRandom.nextInt(ULongArray.getSize-impl(paramArrayOfLong))));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong randomOrNull-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return UArraysKt.randomOrNull-JzugnMA(paramArrayOfLong, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte randomOrNull-oSF2wD8(@NotNull byte[] paramArrayOfByte, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    return UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, paramRandom.nextInt(UByteArray.getSize-impl(paramArrayOfByte))));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort randomOrNull-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UArraysKt.randomOrNull-s5X_as8(paramArrayOfShort, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort randomOrNull-s5X_as8(@NotNull short[] paramArrayOfShort, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    return UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, paramRandom.nextInt(UShortArray.getSize-impl(paramArrayOfShort))));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte reduce-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super UByte, ? super UByte, UByte> paramFunction2)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        b1 = ((UByte)paramFunction2.invoke(UByte.box-impl(b1), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int reduce-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super UInt, ? super UInt, UInt> paramFunction2)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int j = UIntArray.get-impl(paramArrayOfInt, 0);
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      int i = 1;
      for (;;)
      {
        j = ((UInt)paramFunction2.invoke(UInt.box-impl(j), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long reduce-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super ULong, ? super ULong, ULong> paramFunction2)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    long l2 = ULongArray.get-impl(paramArrayOfLong, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        l2 = ((ULong)paramFunction2.invoke(ULong.box-impl(l2), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).unbox-impl();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return l1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short reduce-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super UShort, ? super UShort, UShort> paramFunction2)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        s1 = ((UShort)paramFunction2.invoke(UShort.box-impl(s1), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int reduceIndexed-D40WMg8(@NotNull int[] paramArrayOfInt, Function3<? super Integer, ? super UInt, ? super UInt, UInt> paramFunction3)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int j = UIntArray.get-impl(paramArrayOfInt, 0);
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      int i = 1;
      for (;;)
      {
        j = ((UInt)paramFunction3.invoke(Integer.valueOf(i), UInt.box-impl(j), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte reduceIndexed-EOyYB1Y(@NotNull byte[] paramArrayOfByte, Function3<? super Integer, ? super UByte, ? super UByte, UByte> paramFunction3)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        b1 = ((UByte)paramFunction3.invoke(Integer.valueOf(i), UByte.box-impl(b1), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short reduceIndexed-aLgx1Fo(@NotNull short[] paramArrayOfShort, Function3<? super Integer, ? super UShort, ? super UShort, UShort> paramFunction3)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        s1 = ((UShort)paramFunction3.invoke(Integer.valueOf(i), UShort.box-impl(s1), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).unbox-impl();
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long reduceIndexed-z1zDJgo(@NotNull long[] paramArrayOfLong, Function3<? super Integer, ? super ULong, ? super ULong, ULong> paramFunction3)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    long l2 = ULongArray.get-impl(paramArrayOfLong, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        l2 = ((ULong)paramFunction3.invoke(Integer.valueOf(i), ULong.box-impl(l2), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).unbox-impl();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return l1;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte reduceOrNull-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super UByte, ? super UByte, UByte> paramFunction2)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return null;
    }
    byte b1 = UByteArray.get-impl(paramArrayOfByte, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        b1 = ((UByte)paramFunction2.invoke(UByte.box-impl(b1), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).unbox-impl();
        b2 = b1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    byte b2 = b1;
    return UByte.box-impl(b2);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt reduceOrNull-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super UInt, ? super UInt, UInt> paramFunction2)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return null;
    }
    int j = UIntArray.get-impl(paramArrayOfInt, 0);
    int m = ArraysKt.getLastIndex(paramArrayOfInt);
    if (1 <= m)
    {
      int i = 1;
      for (;;)
      {
        j = ((UInt)paramFunction2.invoke(UInt.box-impl(j), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).unbox-impl();
        k = j;
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    int k = j;
    return UInt.box-impl(k);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong reduceOrNull-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super ULong, ? super ULong, ULong> paramFunction2)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return null;
    }
    long l2 = ULongArray.get-impl(paramArrayOfLong, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    long l1 = l2;
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        l2 = ((ULong)paramFunction2.invoke(ULong.box-impl(l2), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).unbox-impl();
        l1 = l2;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return ULong.box-impl(l1);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort reduceOrNull-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super UShort, ? super UShort, UShort> paramFunction2)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return null;
    }
    short s1 = UShortArray.get-impl(paramArrayOfShort, 0);
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (1 <= j)
    {
      int i = 1;
      for (;;)
      {
        s1 = ((UShort)paramFunction2.invoke(UShort.box-impl(s1), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).unbox-impl();
        s2 = s1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    short s2 = s1;
    return UShort.box-impl(s2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte reduceRight-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super UByte, ? super UByte, UByte> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    byte b = UByteArray.get-impl(paramArrayOfByte, j);
    while (i >= 0)
    {
      b = ((UByte)paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), UByte.box-impl(b))).unbox-impl();
      i -= 1;
    }
    return b;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int reduceRight-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super UInt, ? super UInt, UInt> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfInt);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    j = UIntArray.get-impl(paramArrayOfInt, j);
    while (i >= 0)
    {
      j = ((UInt)paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), UInt.box-impl(j))).unbox-impl();
      i -= 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long reduceRight-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super ULong, ? super ULong, ULong> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    long l = ULongArray.get-impl(paramArrayOfLong, j);
    while (i >= 0)
    {
      l = ((ULong)paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), ULong.box-impl(l))).unbox-impl();
      i -= 1;
    }
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short reduceRight-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super UShort, ? super UShort, UShort> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    short s = UShortArray.get-impl(paramArrayOfShort, j);
    while (i >= 0)
    {
      s = ((UShort)paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), UShort.box-impl(s))).unbox-impl();
      i -= 1;
    }
    return s;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int reduceRightIndexed-D40WMg8(@NotNull int[] paramArrayOfInt, Function3<? super Integer, ? super UInt, ? super UInt, UInt> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    if (i < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int j = UIntArray.get-impl(paramArrayOfInt, i);
    i -= 1;
    while (i >= 0)
    {
      j = ((UInt)paramFunction3.invoke(Integer.valueOf(i), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), UInt.box-impl(j))).unbox-impl();
      i -= 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte reduceRightIndexed-EOyYB1Y(@NotNull byte[] paramArrayOfByte, Function3<? super Integer, ? super UByte, ? super UByte, UByte> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    if (i < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    byte b = UByteArray.get-impl(paramArrayOfByte, i);
    i -= 1;
    while (i >= 0)
    {
      b = ((UByte)paramFunction3.invoke(Integer.valueOf(i), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), UByte.box-impl(b))).unbox-impl();
      i -= 1;
    }
    return b;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short reduceRightIndexed-aLgx1Fo(@NotNull short[] paramArrayOfShort, Function3<? super Integer, ? super UShort, ? super UShort, UShort> paramFunction3)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    if (i < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    short s = UShortArray.get-impl(paramArrayOfShort, i);
    i -= 1;
    while (i >= 0)
    {
      s = ((UShort)paramFunction3.invoke(Integer.valueOf(i), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), UShort.box-impl(s))).unbox-impl();
      i -= 1;
    }
    return s;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long reduceRightIndexed-z1zDJgo(@NotNull long[] paramArrayOfLong, Function3<? super Integer, ? super ULong, ? super ULong, ULong> paramFunction3)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
    }
    int i = j - 1;
    long l = ULongArray.get-impl(paramArrayOfLong, j);
    while (i >= 0)
    {
      l = ((ULong)paramFunction3.invoke(Integer.valueOf(i), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), ULong.box-impl(l))).unbox-impl();
      i -= 1;
    }
    return l;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte reduceRightOrNull-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super UByte, ? super UByte, UByte> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfByte);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    byte b = UByteArray.get-impl(paramArrayOfByte, j);
    while (i >= 0)
    {
      b = ((UByte)paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), UByte.box-impl(b))).unbox-impl();
      i -= 1;
    }
    return UByte.box-impl(b);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt reduceRightOrNull-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super UInt, ? super UInt, UInt> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfInt);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    j = UIntArray.get-impl(paramArrayOfInt, j);
    while (i >= 0)
    {
      j = ((UInt)paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), UInt.box-impl(j))).unbox-impl();
      i -= 1;
    }
    return UInt.box-impl(j);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong reduceRightOrNull-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super ULong, ? super ULong, ULong> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfLong);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    long l = ULongArray.get-impl(paramArrayOfLong, j);
    while (i >= 0)
    {
      l = ((ULong)paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), ULong.box-impl(l))).unbox-impl();
      i -= 1;
    }
    return ULong.box-impl(l);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort reduceRightOrNull-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super UShort, ? super UShort, UShort> paramFunction2)
  {
    int j = ArraysKt.getLastIndex(paramArrayOfShort);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    short s = UShortArray.get-impl(paramArrayOfShort, j);
    while (i >= 0)
    {
      s = ((UShort)paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), UShort.box-impl(s))).unbox-impl();
      i -= 1;
    }
    return UShort.box-impl(s);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void reverse--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    ArraysKt.reverse(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void reverse-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    ArraysKt.reverse(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void reverse-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    ArraysKt.reverse(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void reverse-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    ArraysKt.reverse(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> reversed--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$reversed");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfInt = CollectionsKt.toMutableList(UIntArray.box-impl(paramArrayOfInt));
    CollectionsKt.reverse(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> reversed-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$reversed");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfByte = CollectionsKt.toMutableList(UByteArray.box-impl(paramArrayOfByte));
    CollectionsKt.reverse(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> reversed-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$reversed");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfLong = CollectionsKt.toMutableList(ULongArray.box-impl(paramArrayOfLong));
    CollectionsKt.reverse(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> reversed-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$reversed");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return CollectionsKt.emptyList();
    }
    paramArrayOfShort = CollectionsKt.toMutableList(UShortArray.box-impl(paramArrayOfShort));
    CollectionsKt.reverse(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] reversedArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UIntArray.constructor-impl(ArraysKt.reversedArray(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] reversedArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UByteArray.constructor-impl(ArraysKt.reversedArray(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] reversedArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULongArray.constructor-impl(ArraysKt.reversedArray(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] reversedArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UShortArray.constructor-impl(ArraysKt.reversedArray(paramArrayOfShort));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan-A8wKCXQ(@NotNull long[] paramArrayOfLong, R paramR, Function2<? super R, ? super ULong, ? extends R> paramFunction2)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(ULongArray.getSize-impl(paramArrayOfLong) + 1);
    localArrayList.add(paramR);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, ULong.box-impl(paramArrayOfLong[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan-yXmHNn8(@NotNull byte[] paramArrayOfByte, R paramR, Function2<? super R, ? super UByte, ? extends R> paramFunction2)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UByteArray.getSize-impl(paramArrayOfByte) + 1);
    localArrayList.add(paramR);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UByte.box-impl(paramArrayOfByte[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan-zi1B2BA(@NotNull int[] paramArrayOfInt, R paramR, Function2<? super R, ? super UInt, ? extends R> paramFunction2)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UIntArray.getSize-impl(paramArrayOfInt) + 1);
    localArrayList.add(paramR);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UInt.box-impl(paramArrayOfInt[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scan-zww5nb8(@NotNull short[] paramArrayOfShort, R paramR, Function2<? super R, ? super UShort, ? extends R> paramFunction2)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UShortArray.getSize-impl(paramArrayOfShort) + 1);
    localArrayList.add(paramR);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramR = paramFunction2.invoke(paramR, UShort.box-impl(paramArrayOfShort[i]));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed-3iWJZGE(@NotNull byte[] paramArrayOfByte, R paramR, Function3<? super Integer, ? super R, ? super UByte, ? extends R> paramFunction3)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UByteArray.getSize-impl(paramArrayOfByte) + 1);
    localArrayList.add(paramR);
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfByte);
    int i = localIntRange.getFirst();
    int j = localIntRange.getLast();
    if (i <= j) {
      for (;;)
      {
        paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)));
        localArrayList.add(paramR);
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed-bzxtMww(@NotNull short[] paramArrayOfShort, R paramR, Function3<? super Integer, ? super R, ? super UShort, ? extends R> paramFunction3)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UShortArray.getSize-impl(paramArrayOfShort) + 1);
    localArrayList.add(paramR);
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfShort);
    int i = localIntRange.getFirst();
    int j = localIntRange.getLast();
    if (i <= j) {
      for (;;)
      {
        paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)));
        localArrayList.add(paramR);
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed-mwnnOCs(@NotNull long[] paramArrayOfLong, R paramR, Function3<? super Integer, ? super R, ? super ULong, ? extends R> paramFunction3)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(ULongArray.getSize-impl(paramArrayOfLong) + 1);
    localArrayList.add(paramR);
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfLong);
    int i = localIntRange.getFirst();
    int j = localIntRange.getLast();
    if (i <= j) {
      for (;;)
      {
        paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)));
        localArrayList.add(paramR);
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R> List<R> scanIndexed-yVwIW0Q(@NotNull int[] paramArrayOfInt, R paramR, Function3<? super Integer, ? super R, ? super UInt, ? extends R> paramFunction3)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(UIntArray.getSize-impl(paramArrayOfInt) + 1);
    localArrayList.add(paramR);
    IntRange localIntRange = ArraysKt.getIndices(paramArrayOfInt);
    int i = localIntRange.getFirst();
    int j = localIntRange.getLast();
    if (i <= j) {
      for (;;)
      {
        paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)));
        localArrayList.add(paramR);
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> scanReduce-ELGow60(@NotNull byte[] paramArrayOfByte, Function2<? super UByte, ? super UByte, UByte> paramFunction2)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return CollectionsKt.emptyList();
    }
    byte b = UByteArray.get-impl(paramArrayOfByte, 0);
    ArrayList localArrayList = new ArrayList(UByteArray.getSize-impl(paramArrayOfByte));
    localArrayList.add(UByte.box-impl(b));
    int j = UByteArray.getSize-impl(paramArrayOfByte);
    int i = 1;
    while (i < j)
    {
      b = ((UByte)paramFunction2.invoke(UByte.box-impl(b), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).unbox-impl();
      localArrayList.add(UByte.box-impl(b));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> scanReduce-WyvcNBI(@NotNull int[] paramArrayOfInt, Function2<? super UInt, ? super UInt, UInt> paramFunction2)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return CollectionsKt.emptyList();
    }
    int j = UIntArray.get-impl(paramArrayOfInt, 0);
    ArrayList localArrayList = new ArrayList(UIntArray.getSize-impl(paramArrayOfInt));
    localArrayList.add(UInt.box-impl(j));
    int k = UIntArray.getSize-impl(paramArrayOfInt);
    int i = 1;
    while (i < k)
    {
      j = ((UInt)paramFunction2.invoke(UInt.box-impl(j), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).unbox-impl();
      localArrayList.add(UInt.box-impl(j));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> scanReduce-s8dVfGU(@NotNull long[] paramArrayOfLong, Function2<? super ULong, ? super ULong, ULong> paramFunction2)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return CollectionsKt.emptyList();
    }
    long l = ULongArray.get-impl(paramArrayOfLong, 0);
    ArrayList localArrayList = new ArrayList(ULongArray.getSize-impl(paramArrayOfLong));
    localArrayList.add(ULong.box-impl(l));
    int j = ULongArray.getSize-impl(paramArrayOfLong);
    int i = 1;
    while (i < j)
    {
      l = ((ULong)paramFunction2.invoke(ULong.box-impl(l), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).unbox-impl();
      localArrayList.add(ULong.box-impl(l));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> scanReduce-xzaTVY8(@NotNull short[] paramArrayOfShort, Function2<? super UShort, ? super UShort, UShort> paramFunction2)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return CollectionsKt.emptyList();
    }
    short s = UShortArray.get-impl(paramArrayOfShort, 0);
    ArrayList localArrayList = new ArrayList(UShortArray.getSize-impl(paramArrayOfShort));
    localArrayList.add(UShort.box-impl(s));
    int j = UShortArray.getSize-impl(paramArrayOfShort);
    int i = 1;
    while (i < j)
    {
      s = ((UShort)paramFunction2.invoke(UShort.box-impl(s), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).unbox-impl();
      localArrayList.add(UShort.box-impl(s));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> scanReduceIndexed-D40WMg8(@NotNull int[] paramArrayOfInt, Function3<? super Integer, ? super UInt, ? super UInt, UInt> paramFunction3)
  {
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return CollectionsKt.emptyList();
    }
    int j = UIntArray.get-impl(paramArrayOfInt, 0);
    ArrayList localArrayList = new ArrayList(UIntArray.getSize-impl(paramArrayOfInt));
    localArrayList.add(UInt.box-impl(j));
    int k = UIntArray.getSize-impl(paramArrayOfInt);
    int i = 1;
    while (i < k)
    {
      j = ((UInt)paramFunction3.invoke(Integer.valueOf(i), UInt.box-impl(j), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).unbox-impl();
      localArrayList.add(UInt.box-impl(j));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> scanReduceIndexed-EOyYB1Y(@NotNull byte[] paramArrayOfByte, Function3<? super Integer, ? super UByte, ? super UByte, UByte> paramFunction3)
  {
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return CollectionsKt.emptyList();
    }
    byte b = UByteArray.get-impl(paramArrayOfByte, 0);
    ArrayList localArrayList = new ArrayList(UByteArray.getSize-impl(paramArrayOfByte));
    localArrayList.add(UByte.box-impl(b));
    int j = UByteArray.getSize-impl(paramArrayOfByte);
    int i = 1;
    while (i < j)
    {
      b = ((UByte)paramFunction3.invoke(Integer.valueOf(i), UByte.box-impl(b), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).unbox-impl();
      localArrayList.add(UByte.box-impl(b));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> scanReduceIndexed-aLgx1Fo(@NotNull short[] paramArrayOfShort, Function3<? super Integer, ? super UShort, ? super UShort, UShort> paramFunction3)
  {
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return CollectionsKt.emptyList();
    }
    short s = UShortArray.get-impl(paramArrayOfShort, 0);
    ArrayList localArrayList = new ArrayList(UShortArray.getSize-impl(paramArrayOfShort));
    localArrayList.add(UShort.box-impl(s));
    int j = UShortArray.getSize-impl(paramArrayOfShort);
    int i = 1;
    while (i < j)
    {
      s = ((UShort)paramFunction3.invoke(Integer.valueOf(i), UShort.box-impl(s), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).unbox-impl();
      localArrayList.add(UShort.box-impl(s));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> scanReduceIndexed-z1zDJgo(@NotNull long[] paramArrayOfLong, Function3<? super Integer, ? super ULong, ? super ULong, ULong> paramFunction3)
  {
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return CollectionsKt.emptyList();
    }
    long l = ULongArray.get-impl(paramArrayOfLong, 0);
    ArrayList localArrayList = new ArrayList(ULongArray.getSize-impl(paramArrayOfLong));
    localArrayList.add(ULong.box-impl(l));
    int j = ULongArray.getSize-impl(paramArrayOfLong);
    int i = 1;
    while (i < j)
    {
      l = ((ULong)paramFunction3.invoke(Integer.valueOf(i), ULong.box-impl(l), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).unbox-impl();
      localArrayList.add(ULong.box-impl(l));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int single--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UInt.constructor-impl(ArraysKt.single(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte single-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    return UByte.constructor-impl(ArraysKt.single(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte single-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = 0;
    UByte localUByte = (UByte)null;
    int k = paramArrayOfByte.length;
    int j = 0;
    if (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        break label121;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localUByte = UByte.box-impl(b);
      i = 1;
    }
    label121:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localUByte == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.UByte");
      }
      return localUByte.unbox-impl();
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long single-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = 0;
    ULong localULong = (ULong)null;
    int k = paramArrayOfLong.length;
    int j = 0;
    if (j < k)
    {
      long l = paramArrayOfLong[j];
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        break label119;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localULong = ULong.box-impl(l);
      i = 1;
    }
    label119:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localULong == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.ULong");
      }
      return localULong.unbox-impl();
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long single-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULong.constructor-impl(ArraysKt.single(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int single-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = 0;
    UInt localUInt = (UInt)null;
    int k = paramArrayOfInt.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfInt[j];
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(m))).booleanValue()) {
        break label119;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localUInt = UInt.box-impl(m);
      i = 1;
    }
    label119:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localUInt == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.UInt");
      }
      return localUInt.unbox-impl();
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short single-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    return UShort.constructor-impl(ArraysKt.single(paramArrayOfShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short single-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = 0;
    UShort localUShort = (UShort)null;
    int k = paramArrayOfShort.length;
    int j = 0;
    if (j < k)
    {
      short s = paramArrayOfShort[j];
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        break label121;
      }
      if (i != 0) {
        throw ((Throwable)new IllegalArgumentException("Array contains more than one matching element."));
      }
      localUShort = UShort.box-impl(s);
      i = 1;
    }
    label121:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        throw ((Throwable)new NoSuchElementException("Array contains no element matching the predicate."));
      }
      if (localUShort == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.UShort");
      }
      return localUShort.unbox-impl();
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt singleOrNull--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$singleOrNull");
    if (UIntArray.getSize-impl(paramArrayOfInt) == 1) {
      return UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, 0));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte singleOrNull-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$singleOrNull");
    if (UByteArray.getSize-impl(paramArrayOfByte) == 1) {
      return UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, 0));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UByte singleOrNull-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = 0;
    UByte localUByte = (UByte)null;
    int k = paramArrayOfByte.length;
    int j = 0;
    if (j < k)
    {
      byte b = paramArrayOfByte[j];
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {
        break label76;
      }
      if (i != 0) {
        label50:
        return null;
      }
      localUByte = UByte.box-impl(b);
      i = 1;
    }
    label76:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label50;
      }
      return localUByte;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong singleOrNull-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = 0;
    ULong localULong = (ULong)null;
    int k = paramArrayOfLong.length;
    int j = 0;
    if (j < k)
    {
      long l = paramArrayOfLong[j];
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {
        break label74;
      }
      if (i != 0) {
        label49:
        return null;
      }
      localULong = ULong.box-impl(l);
      i = 1;
    }
    label74:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label49;
      }
      return localULong;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong singleOrNull-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$singleOrNull");
    if (ULongArray.getSize-impl(paramArrayOfLong) == 1) {
      return ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, 0));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt singleOrNull-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = 0;
    UInt localUInt = (UInt)null;
    int k = paramArrayOfInt.length;
    int j = 0;
    if (j < k)
    {
      int m = paramArrayOfInt[j];
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(m))).booleanValue()) {
        break label74;
      }
      if (i != 0) {
        label49:
        return null;
      }
      localUInt = UInt.box-impl(m);
      i = 1;
    }
    label74:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label49;
      }
      return localUInt;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort singleOrNull-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$singleOrNull");
    if (UShortArray.getSize-impl(paramArrayOfShort) == 1) {
      return UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, 0));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UShort singleOrNull-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = 0;
    UShort localUShort = (UShort)null;
    int k = paramArrayOfShort.length;
    int j = 0;
    if (j < k)
    {
      short s = paramArrayOfShort[j];
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {
        break label76;
      }
      if (i != 0) {
        label50:
        return null;
      }
      localUShort = UShort.box-impl(s);
      i = 1;
    }
    label76:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        break label50;
      }
      return localUShort;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> slice-F7u83W8(@NotNull long[] paramArrayOfLong, @NotNull Iterable<Integer> paramIterable)
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
      localArrayList.add(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, ((Number)paramIterable.next()).intValue())));
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> slice-HwE9HBo(@NotNull int[] paramArrayOfInt, @NotNull Iterable<Integer> paramIterable)
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
      localArrayList.add(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, ((Number)paramIterable.next()).intValue())));
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> slice-JGPC0-M(@NotNull short[] paramArrayOfShort, @NotNull Iterable<Integer> paramIterable)
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
      localArrayList.add(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, ((Number)paramIterable.next()).intValue())));
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> slice-JQknh5Q(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<Integer> paramIterable)
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
      localArrayList.add(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, ((Number)paramIterable.next()).intValue())));
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> slice-Q6IL4kU(@NotNull short[] paramArrayOfShort, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return UArraysKt.asList-rL5Bavg(UShortArray.constructor-impl(ArraysKt.copyOfRange(paramArrayOfShort, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> slice-ZRhS8yI(@NotNull long[] paramArrayOfLong, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return UArraysKt.asList-QwZRm1k(ULongArray.constructor-impl(ArraysKt.copyOfRange(paramArrayOfLong, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> slice-c0bezYM(@NotNull byte[] paramArrayOfByte, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return UArraysKt.asList-GBYM_sE(UByteArray.constructor-impl(ArraysKt.copyOfRange(paramArrayOfByte, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> slice-tAntMlw(@NotNull int[] paramArrayOfInt, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return CollectionsKt.emptyList();
    }
    return UArraysKt.asList--ajY-9A(UIntArray.constructor-impl(ArraysKt.copyOfRange(paramArrayOfInt, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] sliceArray-CFIt9YE(@NotNull int[] paramArrayOfInt, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    return UIntArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfInt, paramCollection));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] sliceArray-Q6IL4kU(@NotNull short[] paramArrayOfShort, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    return UShortArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfShort, paramIntRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] sliceArray-ZRhS8yI(@NotNull long[] paramArrayOfLong, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    return ULongArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfLong, paramIntRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] sliceArray-c0bezYM(@NotNull byte[] paramArrayOfByte, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    return UByteArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfByte, paramIntRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] sliceArray-kzHmqpY(@NotNull long[] paramArrayOfLong, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    return ULongArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfLong, paramCollection));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] sliceArray-ojwP5H8(@NotNull short[] paramArrayOfShort, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    return UShortArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfShort, paramCollection));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] sliceArray-tAntMlw(@NotNull int[] paramArrayOfInt, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    return UIntArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfInt, paramIntRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] sliceArray-xo_DsdI(@NotNull byte[] paramArrayOfByte, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sliceArray");
    Intrinsics.checkParameterIsNotNull(paramCollection, "indices");
    return UByteArray.constructor-impl(ArraysKt.sliceArray(paramArrayOfByte, paramCollection));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sort--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sort");
    if (UIntArray.getSize-impl(paramArrayOfInt) > 1) {
      UArraySortingKt.sortArray--ajY-9A(paramArrayOfInt);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sort-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sort");
    if (UByteArray.getSize-impl(paramArrayOfByte) > 1) {
      UArraySortingKt.sortArray-GBYM_sE(paramArrayOfByte);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sort-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sort");
    if (ULongArray.getSize-impl(paramArrayOfLong) > 1) {
      UArraySortingKt.sortArray-QwZRm1k(paramArrayOfLong);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sort-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sort");
    if (UShortArray.getSize-impl(paramArrayOfShort) > 1) {
      UArraySortingKt.sortArray-rL5Bavg(paramArrayOfShort);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sortDescending--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortDescending");
    if (UIntArray.getSize-impl(paramArrayOfInt) > 1)
    {
      UArraysKt.sort--ajY-9A(paramArrayOfInt);
      ArraysKt.reverse(paramArrayOfInt);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sortDescending-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortDescending");
    if (UByteArray.getSize-impl(paramArrayOfByte) > 1)
    {
      UArraysKt.sort-GBYM_sE(paramArrayOfByte);
      ArraysKt.reverse(paramArrayOfByte);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sortDescending-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortDescending");
    if (ULongArray.getSize-impl(paramArrayOfLong) > 1)
    {
      UArraysKt.sort-QwZRm1k(paramArrayOfLong);
      ArraysKt.reverse(paramArrayOfLong);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final void sortDescending-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortDescending");
    if (UShortArray.getSize-impl(paramArrayOfShort) > 1)
    {
      UArraysKt.sort-rL5Bavg(paramArrayOfShort);
      ArraysKt.reverse(paramArrayOfShort);
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> sorted--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sorted");
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfInt = UIntArray.constructor-impl(paramArrayOfInt);
    UArraysKt.sort--ajY-9A(paramArrayOfInt);
    return UArraysKt.asList--ajY-9A(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> sorted-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sorted");
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfByte = UByteArray.constructor-impl(paramArrayOfByte);
    UArraysKt.sort-GBYM_sE(paramArrayOfByte);
    return UArraysKt.asList-GBYM_sE(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> sorted-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sorted");
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfLong = ULongArray.constructor-impl(paramArrayOfLong);
    UArraysKt.sort-QwZRm1k(paramArrayOfLong);
    return UArraysKt.asList-QwZRm1k(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> sorted-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sorted");
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfShort = UShortArray.constructor-impl(paramArrayOfShort);
    UArraysKt.sort-rL5Bavg(paramArrayOfShort);
    return UArraysKt.asList-rL5Bavg(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] sortedArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedArray");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return paramArrayOfInt;
    }
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfInt = UIntArray.constructor-impl(paramArrayOfInt);
    UArraysKt.sort--ajY-9A(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] sortedArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedArray");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return paramArrayOfByte;
    }
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfByte = UByteArray.constructor-impl(paramArrayOfByte);
    UArraysKt.sort-GBYM_sE(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] sortedArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedArray");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return paramArrayOfLong;
    }
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfLong = ULongArray.constructor-impl(paramArrayOfLong);
    UArraysKt.sort-QwZRm1k(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] sortedArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedArray");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return paramArrayOfShort;
    }
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfShort = UShortArray.constructor-impl(paramArrayOfShort);
    UArraysKt.sort-rL5Bavg(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] sortedArrayDescending--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedArrayDescending");
    if (UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return paramArrayOfInt;
    }
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfInt = UIntArray.constructor-impl(paramArrayOfInt);
    UArraysKt.sortDescending--ajY-9A(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] sortedArrayDescending-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedArrayDescending");
    if (UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return paramArrayOfByte;
    }
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfByte = UByteArray.constructor-impl(paramArrayOfByte);
    UArraysKt.sortDescending-GBYM_sE(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] sortedArrayDescending-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedArrayDescending");
    if (ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return paramArrayOfLong;
    }
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfLong = ULongArray.constructor-impl(paramArrayOfLong);
    UArraysKt.sortDescending-QwZRm1k(paramArrayOfLong);
    return paramArrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] sortedArrayDescending-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedArrayDescending");
    if (UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return paramArrayOfShort;
    }
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfShort = UShortArray.constructor-impl(paramArrayOfShort);
    UArraysKt.sortDescending-rL5Bavg(paramArrayOfShort);
    return paramArrayOfShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> sortedDescending--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sortedDescending");
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfInt = UIntArray.constructor-impl(paramArrayOfInt);
    UArraysKt.sort--ajY-9A(paramArrayOfInt);
    return UArraysKt.reversed--ajY-9A(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> sortedDescending-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sortedDescending");
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfByte = UByteArray.constructor-impl(paramArrayOfByte);
    UArraysKt.sort-GBYM_sE(paramArrayOfByte);
    return UArraysKt.reversed-GBYM_sE(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> sortedDescending-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sortedDescending");
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfLong = ULongArray.constructor-impl(paramArrayOfLong);
    UArraysKt.sort-QwZRm1k(paramArrayOfLong);
    return UArraysKt.reversed-QwZRm1k(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> sortedDescending-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sortedDescending");
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    paramArrayOfShort = UShortArray.constructor-impl(paramArrayOfShort);
    UArraysKt.sort-rL5Bavg(paramArrayOfShort);
    return UArraysKt.reversed-rL5Bavg(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sum--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    return UInt.constructor-impl(ArraysKt.sum(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sum-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(j + UInt.constructor-impl(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long sum-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    return ULong.constructor-impl(ArraysKt.sum(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sum-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    int i = 0;
    int k = paramArrayOfShort.length;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(j + UInt.constructor-impl(paramArrayOfShort[i] & 0xFFFF));
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sumBy-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, UInt> paramFunction1)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(((UInt)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]))).unbox-impl() + j);
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sumBy-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, UInt> paramFunction1)
  {
    int k = paramArrayOfLong.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(((UInt)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]))).unbox-impl() + j);
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sumBy-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, UInt> paramFunction1)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(((UInt)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]))).unbox-impl() + j);
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int sumBy-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, UInt> paramFunction1)
  {
    int k = paramArrayOfShort.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(((UInt)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]))).unbox-impl() + j);
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final double sumByDouble-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Double> paramFunction1)
  {
    double d = 0.0D;
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(UByte.box-impl(paramArrayOfByte[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final double sumByDouble-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Double> paramFunction1)
  {
    double d = 0.0D;
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(ULong.box-impl(paramArrayOfLong[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final double sumByDouble-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Double> paramFunction1)
  {
    double d = 0.0D;
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(UInt.box-impl(paramArrayOfInt[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final double sumByDouble-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Double> paramFunction1)
  {
    double d = 0.0D;
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      d += ((Number)paramFunction1.invoke(UShort.box-impl(paramArrayOfShort[i]))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUByte")
  public static final int sumOfUByte(@NotNull UByte[] paramArrayOfUByte)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfUByte, "$this$sum");
    int k = paramArrayOfUByte.length;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(j + UInt.constructor-impl(paramArrayOfUByte[i].unbox-impl() & 0xFF));
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUInt")
  public static final int sumOfUInt(@NotNull UInt[] paramArrayOfUInt)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfUInt, "$this$sum");
    int k = paramArrayOfUInt.length;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(j + paramArrayOfUInt[i].unbox-impl());
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfULong")
  public static final long sumOfULong(@NotNull ULong[] paramArrayOfULong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfULong, "$this$sum");
    long l = 0L;
    int j = paramArrayOfULong.length;
    int i = 0;
    while (i < j)
    {
      l = ULong.constructor-impl(l + paramArrayOfULong[i].unbox-impl());
      i += 1;
    }
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUShort")
  public static final int sumOfUShort(@NotNull UShort[] paramArrayOfUShort)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfUShort, "$this$sum");
    int k = paramArrayOfUShort.length;
    int j = 0;
    while (i < k)
    {
      j = UInt.constructor-impl(j + UInt.constructor-impl(paramArrayOfUShort[i].unbox-impl() & 0xFFFF));
      i += 1;
    }
    return j;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> take-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
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
    if (paramInt >= UByteArray.getSize-impl(paramArrayOfByte)) {
      return CollectionsKt.toList(UByteArray.box-impl(paramArrayOfByte));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, 0)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfByte.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(UByte.box-impl(paramArrayOfByte[i]));
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> take-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
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
    if (paramInt >= UShortArray.getSize-impl(paramArrayOfShort)) {
      return CollectionsKt.toList(UShortArray.box-impl(paramArrayOfShort));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, 0)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfShort.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(UShort.box-impl(paramArrayOfShort[i]));
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> take-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
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
    if (paramInt >= UIntArray.getSize-impl(paramArrayOfInt)) {
      return CollectionsKt.toList(UIntArray.box-impl(paramArrayOfInt));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, 0)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfInt.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(UInt.box-impl(paramArrayOfInt[i]));
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> take-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
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
    if (paramInt >= ULongArray.getSize-impl(paramArrayOfLong)) {
      return CollectionsKt.toList(ULongArray.box-impl(paramArrayOfLong));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, 0)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    int m = paramArrayOfLong.length;
    int j = 0;
    i = k;
    for (;;)
    {
      if (i < m)
      {
        localArrayList.add(ULong.box-impl(paramArrayOfLong[i]));
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
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> takeLast-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = UByteArray.getSize-impl(paramArrayOfByte);
    if (paramInt >= i) {
      return CollectionsKt.toList(UByteArray.box-impl(paramArrayOfByte));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i - 1)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, paramInt)));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> takeLast-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = UShortArray.getSize-impl(paramArrayOfShort);
    if (paramInt >= i) {
      return CollectionsKt.toList(UShortArray.box-impl(paramArrayOfShort));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i - 1)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, paramInt)));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> takeLast-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = UIntArray.getSize-impl(paramArrayOfInt);
    if (paramInt >= i) {
      return CollectionsKt.toList(UIntArray.box-impl(paramArrayOfInt));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i - 1)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, paramInt)));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> takeLast-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString()));
    }
    if (paramInt == 0) {
      return CollectionsKt.emptyList();
    }
    i = ULongArray.getSize-impl(paramArrayOfLong);
    if (paramInt >= i) {
      return CollectionsKt.toList(ULongArray.box-impl(paramArrayOfLong));
    }
    if (paramInt == 1) {
      return CollectionsKt.listOf(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i - 1)));
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramInt = i - paramInt;
    while (paramInt < i)
    {
      localArrayList.add(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, paramInt)));
      paramInt += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> takeLastWhile-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfByte);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)))).booleanValue()) {
        return UArraysKt.drop-PpDY95g(paramArrayOfByte, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.toList(UByteArray.box-impl(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> takeLastWhile-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfLong);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)))).booleanValue()) {
        return UArraysKt.drop-r7IrZao(paramArrayOfLong, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.toList(ULongArray.box-impl(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> takeLastWhile-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfInt);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)))).booleanValue()) {
        return UArraysKt.drop-qFRl0hI(paramArrayOfInt, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.toList(UIntArray.box-impl(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> takeLastWhile-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    int i = ArraysKt.getLastIndex(paramArrayOfShort);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)))).booleanValue()) {
        return UArraysKt.drop-nggk6HY(paramArrayOfShort, i + 1);
      }
      i -= 1;
    }
    return CollectionsKt.toList(UShortArray.box-impl(paramArrayOfShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UByte> takeWhile-JOV_ifY(@NotNull byte[] paramArrayOfByte, Function1<? super UByte, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      byte b;
      if (i < j)
      {
        b = paramArrayOfByte[i];
        if (((Boolean)paramFunction1.invoke(UByte.box-impl(b))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(UByte.box-impl(b));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<ULong> takeWhile-MShoTSo(@NotNull long[] paramArrayOfLong, Function1<? super ULong, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      long l;
      if (i < j)
      {
        l = paramArrayOfLong[i];
        if (((Boolean)paramFunction1.invoke(ULong.box-impl(l))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(ULong.box-impl(l));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UInt> takeWhile-jgv0xPQ(@NotNull int[] paramArrayOfInt, Function1<? super UInt, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j)
      {
        k = paramArrayOfInt[i];
        if (((Boolean)paramFunction1.invoke(UInt.box-impl(k))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(UInt.box-impl(k));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final List<UShort> takeWhile-xTcfx_M(@NotNull short[] paramArrayOfShort, Function1<? super UShort, Boolean> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      short s;
      if (i < j)
      {
        s = paramArrayOfShort[i];
        if (((Boolean)paramFunction1.invoke(UShort.box-impl(s))).booleanValue()) {}
      }
      else
      {
        return (List)localArrayList;
      }
      localArrayList.add(UShort.box-impl(s));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] toByteArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] toIntArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] toLongArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] toShortArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UInt[] toTypedArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toTypedArray");
    int j = UIntArray.getSize-impl(paramArrayOfInt);
    UInt[] arrayOfUInt = new UInt[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUInt[i] = UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i));
      i += 1;
    }
    return arrayOfUInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UByte[] toTypedArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toTypedArray");
    int j = UByteArray.getSize-impl(paramArrayOfByte);
    UByte[] arrayOfUByte = new UByte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUByte[i] = UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i));
      i += 1;
    }
    return arrayOfUByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULong[] toTypedArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toTypedArray");
    int j = ULongArray.getSize-impl(paramArrayOfLong);
    ULong[] arrayOfULong = new ULong[j];
    int i = 0;
    while (i < j)
    {
      arrayOfULong[i] = ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i));
      i += 1;
    }
    return arrayOfULong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UShort[] toTypedArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toTypedArray");
    int j = UShortArray.getSize-impl(paramArrayOfShort);
    UShort[] arrayOfUShort = new UShort[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUShort[i] = UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i));
      i += 1;
    }
    return arrayOfUShort;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte[] toUByteArray(@NotNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return UByteArray.constructor-impl(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] toUByteArray(@NotNull UByte[] paramArrayOfUByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfUByte, "$this$toUByteArray");
    int j = paramArrayOfUByte.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = paramArrayOfUByte[i].unbox-impl();
      i += 1;
    }
    return UByteArray.constructor-impl(arrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] toUIntArray(@NotNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    return UIntArray.constructor-impl(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] toUIntArray(@NotNull UInt[] paramArrayOfUInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfUInt, "$this$toUIntArray");
    int j = paramArrayOfUInt.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramArrayOfUInt[i].unbox-impl();
      i += 1;
    }
    return UIntArray.constructor-impl(arrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long[] toULongArray(@NotNull long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    return ULongArray.constructor-impl(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] toULongArray(@NotNull ULong[] paramArrayOfULong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfULong, "$this$toULongArray");
    int j = paramArrayOfULong.length;
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = paramArrayOfULong[i].unbox-impl();
      i += 1;
    }
    return ULongArray.constructor-impl(arrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] toUShortArray(@NotNull UShort[] paramArrayOfUShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfUShort, "$this$toUShortArray");
    int j = paramArrayOfUShort.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = paramArrayOfUShort[i].unbox-impl();
      i += 1;
    }
    return UShortArray.constructor-impl(arrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] toUShortArray(@NotNull short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    return UShortArray.constructor-impl(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Iterable<IndexedValue<UInt>> withIndex--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new UArraysKt___UArraysKt.withIndex.1(paramArrayOfInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Iterable<IndexedValue<UByte>> withIndex-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new UArraysKt___UArraysKt.withIndex.3(paramArrayOfByte));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Iterable<IndexedValue<ULong>> withIndex-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new UArraysKt___UArraysKt.withIndex.2(paramArrayOfLong));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Iterable<IndexedValue<UShort>> withIndex-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new UArraysKt___UArraysKt.withIndex.4(paramArrayOfShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-7znnbtw(@NotNull int[] paramArrayOfInt, Iterable<? extends R> paramIterable, Function2<? super UInt, ? super R, ? extends V> paramFunction2)
  {
    int j = UIntArray.getSize-impl(paramArrayOfInt);
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
      localArrayList.add(paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-8LME4QE(@NotNull long[] paramArrayOfLong, R[] paramArrayOfR, Function2<? super ULong, ? super R, ? extends V> paramFunction2)
  {
    int j = Math.min(ULongArray.getSize-impl(paramArrayOfLong), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UInt, R>> zip-C-E_24M(@NotNull int[] paramArrayOfInt, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(UIntArray.getSize-impl(paramArrayOfInt), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      int k = UIntArray.get-impl(paramArrayOfInt, i);
      R ? = paramArrayOfR[i];
      localArrayList.add(TuplesKt.to(UInt.box-impl(k), ?));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<ULong, R>> zip-F7u83W8(@NotNull long[] paramArrayOfLong, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = ULongArray.getSize-impl(paramArrayOfLong);
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
      localArrayList.add(TuplesKt.to(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UInt, R>> zip-HwE9HBo(@NotNull int[] paramArrayOfInt, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = UIntArray.getSize-impl(paramArrayOfInt);
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
      localArrayList.add(TuplesKt.to(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <V> List<V> zip-JAKpvQM(@NotNull byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, Function2<? super UByte, ? super UByte, ? extends V> paramFunction2)
  {
    int j = Math.min(UByteArray.getSize-impl(paramArrayOfByte1), UByteArray.getSize-impl(paramArrayOfByte2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte1, i)), UByte.box-impl(UByteArray.get-impl(paramArrayOfByte2, i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UShort, R>> zip-JGPC0-M(@NotNull short[] paramArrayOfShort, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = UShortArray.getSize-impl(paramArrayOfShort);
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
      localArrayList.add(TuplesKt.to(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UByte, R>> zip-JQknh5Q(@NotNull byte[] paramArrayOfByte, @NotNull Iterable<? extends R> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramIterable, "other");
    int j = UByteArray.getSize-impl(paramArrayOfByte);
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
      localArrayList.add(TuplesKt.to(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <V> List<V> zip-L83TJbI(@NotNull int[] paramArrayOfInt1, int[] paramArrayOfInt2, Function2<? super UInt, ? super UInt, ? extends V> paramFunction2)
  {
    int j = Math.min(UIntArray.getSize-impl(paramArrayOfInt1), UIntArray.getSize-impl(paramArrayOfInt2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt1, i)), UInt.box-impl(UIntArray.get-impl(paramArrayOfInt2, i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-LuipOMY(@NotNull byte[] paramArrayOfByte, R[] paramArrayOfR, Function2<? super UByte, ? super R, ? extends V> paramFunction2)
  {
    int j = Math.min(UByteArray.getSize-impl(paramArrayOfByte), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <V> List<V> zip-PabeH-Q(@NotNull long[] paramArrayOfLong1, long[] paramArrayOfLong2, Function2<? super ULong, ? super ULong, ? extends V> paramFunction2)
  {
    int j = Math.min(ULongArray.getSize-impl(paramArrayOfLong1), ULongArray.getSize-impl(paramArrayOfLong2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong1, i)), ULong.box-impl(ULongArray.get-impl(paramArrayOfLong2, i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-TUPTUsU(@NotNull long[] paramArrayOfLong, Iterable<? extends R> paramIterable, Function2<? super ULong, ? super R, ? extends V> paramFunction2)
  {
    int j = ULongArray.getSize-impl(paramArrayOfLong);
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
      localArrayList.add(paramFunction2.invoke(ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-UCnP4_w(@NotNull byte[] paramArrayOfByte, Iterable<? extends R> paramIterable, Function2<? super UByte, ? super R, ? extends V> paramFunction2)
  {
    int j = UByteArray.getSize-impl(paramArrayOfByte);
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
      localArrayList.add(paramFunction2.invoke(UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-ZjwqOic(@NotNull int[] paramArrayOfInt, R[] paramArrayOfR, Function2<? super UInt, ? super R, ? extends V> paramFunction2)
  {
    int j = Math.min(UIntArray.getSize-impl(paramArrayOfInt), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i)), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Pair<UInt, UInt>> zip-ctEhBpI(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    int j = Math.min(UIntArray.getSize-impl(paramArrayOfInt1), UIntArray.getSize-impl(paramArrayOfInt2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      int k = UIntArray.get-impl(paramArrayOfInt1, i);
      int m = UIntArray.get-impl(paramArrayOfInt2, i);
      localArrayList.add(TuplesKt.to(UInt.box-impl(k), UInt.box-impl(m)));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-ePBmRWY(@NotNull short[] paramArrayOfShort, R[] paramArrayOfR, Function2<? super UShort, ? super R, ? extends V> paramFunction2)
  {
    int j = Math.min(UShortArray.getSize-impl(paramArrayOfShort), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), paramArrayOfR[i]));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<ULong, R>> zip-f7H3mmw(@NotNull long[] paramArrayOfLong, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(ULongArray.getSize-impl(paramArrayOfLong), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      long l = ULongArray.get-impl(paramArrayOfLong, i);
      R ? = paramArrayOfR[i];
      localArrayList.add(TuplesKt.to(ULong.box-impl(l), ?));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <V> List<V> zip-gVVukQo(@NotNull short[] paramArrayOfShort1, short[] paramArrayOfShort2, Function2<? super UShort, ? super UShort, ? extends V> paramFunction2)
  {
    int j = Math.min(UShortArray.getSize-impl(paramArrayOfShort1), UShortArray.getSize-impl(paramArrayOfShort2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort1, i)), UShort.box-impl(UShortArray.get-impl(paramArrayOfShort2, i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <R, V> List<V> zip-kBb4a-s(@NotNull short[] paramArrayOfShort, Iterable<? extends R> paramIterable, Function2<? super UShort, ? super R, ? extends V> paramFunction2)
  {
    int j = UShortArray.getSize-impl(paramArrayOfShort);
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
      localArrayList.add(paramFunction2.invoke(UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i)), localObject));
      i += 1;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Pair<UByte, UByte>> zip-kdPth3s(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    int j = Math.min(UByteArray.getSize-impl(paramArrayOfByte1), UByteArray.getSize-impl(paramArrayOfByte2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      byte b1 = UByteArray.get-impl(paramArrayOfByte1, i);
      byte b2 = UByteArray.get-impl(paramArrayOfByte2, i);
      localArrayList.add(TuplesKt.to(UByte.box-impl(b1), UByte.box-impl(b2)));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Pair<UShort, UShort>> zip-mazbYpA(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    int j = Math.min(UShortArray.getSize-impl(paramArrayOfShort1), UShortArray.getSize-impl(paramArrayOfShort2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      short s1 = UShortArray.get-impl(paramArrayOfShort1, i);
      short s2 = UShortArray.get-impl(paramArrayOfShort2, i);
      localArrayList.add(TuplesKt.to(UShort.box-impl(s1), UShort.box-impl(s2)));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UByte, R>> zip-nl983wc(@NotNull byte[] paramArrayOfByte, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(UByteArray.getSize-impl(paramArrayOfByte), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      byte b = UByteArray.get-impl(paramArrayOfByte, i);
      R ? = paramArrayOfR[i];
      localArrayList.add(TuplesKt.to(UByte.box-impl(b), ?));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<Pair<UShort, R>> zip-uaTIQ5s(@NotNull short[] paramArrayOfShort, @NotNull R[] paramArrayOfR)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfR, "other");
    int j = Math.min(UShortArray.getSize-impl(paramArrayOfShort), paramArrayOfR.length);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      short s = UShortArray.get-impl(paramArrayOfShort, i);
      R ? = paramArrayOfR[i];
      localArrayList.add(TuplesKt.to(UShort.box-impl(s), ?));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Pair<ULong, ULong>> zip-us8wMrg(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    int j = Math.min(ULongArray.getSize-impl(paramArrayOfLong1), ULongArray.getSize-impl(paramArrayOfLong2));
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      long l1 = ULongArray.get-impl(paramArrayOfLong1, i);
      long l2 = ULongArray.get-impl(paramArrayOfLong2, i);
      localArrayList.add(TuplesKt.to(ULong.box-impl(l1), ULong.box-impl(l2)));
      i += 1;
    }
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysKt
 * JD-Core Version:    0.7.0.1
 */