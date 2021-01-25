package ch.adesso.pathfinder;

import java.awt.Point;
import java.util.*;

/*
Die Hand-Methode ist die bekannteste Regel, einen Irrgarten zu durchqueren.
Man legt einfach seine linke oder rechte Hand an eine Wand des Irrgartens und hält dann beim Durchlaufen ständigen Kontakt.
Falls alle Mauern zusammenhängen oder mit der Aussenseite verbunden sind, das heisst, der Irrgarten ist einfach zusammenhängend, garantiert die Hand-Methode,
dass man entweder einen anderen Ausgang erreicht, oder wieder zum Eingang zurückkehrt.
*/
public class PathFinderLogicHand implements PathFinderLogic {

	@Override
	public DIRECTIONS getNewDirection(Labyrinth labyrinth, Point position, DIRECTIONS oldDirection) {
		return null;
	}

}
