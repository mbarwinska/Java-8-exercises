package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream().map(x->Math.sqrt(x.doubleValue())).map(x->x.intValue()).collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
       return user.stream().map(x->x.getAge()).collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().map(x->x.getAge()).distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
       return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return users.stream().filter(x->x.getAge() > 25).collect(Collectors.counting()).intValue();
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream().reduce((a, b) -> a + b).orElse(0);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream().map(x-> x.split(" ")).map(x->x[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream().map(x->x.split("")).flatMap(x-> Arrays.stream(x)).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users){
        return users.stream().map(x->x.getName()).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().map(x->x.getAge()).mapToDouble(x->x).average().orElse(0);
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream().map(x->x.getAge()).max(Comparator.naturalOrder()).orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().map(x->x.getAge()).min(Comparator.naturalOrder()).orElse(0);
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(partitioningBy(x->x.isMale()));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy(x->x.getAge()));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        Map<Boolean, Map<Integer, List<User>>> usersGrouped = users
                .stream()
                .collect(Collectors.groupingBy(x -> x.isMale(),
                        Collectors.groupingBy(x -> x.getAge())));
        return usersGrouped;
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        Map<Boolean, Long> userSumByGender = users.stream().collect(Collectors.groupingBy(x -> x.isMale(), counting()));
        return userSumByGender;
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream().anyMatch(x->x.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream().noneMatch(x->x.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream().filter(x->x.getName().equals(name)).findAny();
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(x->x.getAge())).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        return Stream.iterate(2, x -> x + 1).filter(integer -> Stream8.isPrime(integer)).limit(10).collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return IntStream.generate(new Random()::nextInt).limit(10).boxed().collect(Collectors.toList());
    }

    public static User findOldest(List<User> users){
        User oldestUser = users.stream().max(Comparator.comparing(x -> x.getAge())).get();
        return oldestUser;
    }

    public static int sumAge(List<User> users){
        return users.stream().map(x->x.getAge()).mapToInt(x->x).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){

    return users.stream().mapToInt(x->x.getAge()).summaryStatistics() ;
    }

}
