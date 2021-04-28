package es.uji.ei1027.clubesportiu.services;


import es.uji.ei1027.clubesportiu.model.Nadador;
import java.util.Map;
import java.util.List;

public interface ClassificacioService {
    Map<String, List<Nadador>> getClassificationByCountry(String prova);
    Map<String, List<Nadador>> getClassificationByProva(String country);
    List<String> getNadadorsElegiblesPerProva(String prova);
}
