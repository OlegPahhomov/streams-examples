package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Main {


    public static final Integer TAISEA_VANUS = 18;

    public static void main(String[] args) {
        List<Isik> isikud = new ArrayList<>();

        List<Isik> taisEalisedIsikud = new ArrayList<>();
        for (Isik isik : isikud) {
            if (isik.getVanus() >= TAISEA_VANUS) {
                taisEalisedIsikud.add(isik);
            }
        }


        isikud.stream()
                .filter(Main::isTaisealine)
                .collect(Collectors.toList());


        List<Long> ids = new ArrayList<>();
        for (Isik isik : isikud) {
            ids.add(isik.getId());
        }

        List<Long> ids3 = isikud.stream()
                .mapToLong(i -> i.getId())
                .boxed()
                .collect(Collectors.toList());

        List<Long> ids2 = isikud.stream()
                .map(Isik::getId)
                .collect(Collectors.toList());


        List<Aadress> collect = isikud.stream()
                .map(Isik::getAadressid)
                .flatMap(Collection::stream)
                .collect(collectingAndThen(toCollection(
                                () -> new TreeSet<>(Comparator.comparingLong(Aadress::getPostiIndeks))),
                        ArrayList::new));

        Map<Integer, List<Isik>> collect1 = isikud.stream()
                .collect(Collectors.groupingBy(Isik::getVanus));

        Map<Long, Isik> collect2 = isikud.stream()
                .collect(Collectors.toMap(Isik::getId, i -> i));

        Stream<Isik> isikStream = isikud.stream().filter(i -> i.getVanus() <= 5);
        System.out.println(isikStream);

        Map<Boolean, List<Isik>> collect3 = isikud.stream()
                .collect(Collectors.partitioningBy(Main::isTaisealine));

        Optional<Long> idOfEestiLaps = isikud.stream()
                .filter(i -> i.getAadressid().stream()
                        .allMatch(a -> a.getRiik().equals("EST")))
                .filter(i -> i.getVanus() <= 5)
                .map(Isik::getId)
                .findFirst();

        Isik isik = new Isik();
        isik.setAadressid(new ArrayList<>());
        Aadress olemasOlevEestiVoiDefaultAadress = isik.getAadressid().stream()
                .filter(a -> a.getRiik().equals("EST"))
                .findAny()
                .orElse(new Aadress(11221, "EST"));

        boolean koikEestiAadressid = isik.getAadressid().stream()
                .allMatch(a -> a.getRiik().equals("EST"));

        List<IsikDto> isikDto = new ArrayList<>();
        for (int i = 0; i < isikud.size() - 1; i++) {
            isikDto.add(new IsikDto(isikud.get(i), isikud.get(i + 1)));
        }

        List<IsikDto> collect4 = IntStream.range(0, isikud.size() - 1)
                .mapToObj(i -> new IsikDto(isikud.get(i), isikud.get(i + 1)))
                .collect(Collectors.toList());

        Integer collect5 = isikud.stream()
                .collect(Collectors.summingInt(Isik::getVanus));

        OptionalInt reduce = isikud.stream()
                .mapToInt(Isik::getVanus)
                .reduce((i1, i2) -> i1 + i2);

        int sum = isikud.stream()
                .mapToInt(Isik::getVanus)
                .sum();
    }

    private static boolean isTaisealine(Isik i) {
        return i.getVanus() >= TAISEA_VANUS;
    }
}
