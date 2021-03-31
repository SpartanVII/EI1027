package es.uji.ei1027.clubesportiu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uji.ei1027.clubesportiu.dao.ProvaDao;
import es.uji.ei1027.clubesportiu.model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.clubesportiu.dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.dao.NadadorDao;
import es.uji.ei1027.clubesportiu.model.Classificacio;
import es.uji.ei1027.clubesportiu.model.Nadador;

@Service
public class ClassificacioSvc implements ClassificacioService {

    @Autowired
    NadadorDao nadadorDao;

    ///
    @Autowired
    ProvaDao provaDao;

    @Autowired
    ClassificacioDao classificacioDao;

    @Override
    public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
        List<Classificacio> classProva = classificacioDao.getClassificacioProva(prova);
        HashMap<String,List<Nadador>> nadadorsPerPais =
                new HashMap<String,List<Nadador>>();
        for (Classificacio clsf : classProva) {
            Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
            if (!nadadorsPerPais.containsKey(nadador.getPais()))
                nadadorsPerPais.put(nadador.getPais(),
                        new ArrayList<Nadador>());
            nadadorsPerPais.get(nadador.getPais()).add(nadador);
        }
        return nadadorsPerPais;
    }


    ///
    ///
    ///
    @Override
    public Map<String, List<Nadador>> getClassificationByProva(String country) {

        List<Classificacio> classPais = classificacioDao.getClassificacioPais(country);
        HashMap<String,List<Nadador>> nadadorsPerProva = new HashMap<String,List<Nadador>>();

        for (Classificacio clsf : classPais) {
            Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());

            if (!nadadorsPerProva.containsKey(nadador.))
                nadadorsPerProva.put(nadador.getNumFederat(), new ArrayList<Nadador>());
            nadadorsPerProva.get(nadador.getPais()).add(nadador);
        }
        return nadadorsPerProva;
    }
}
